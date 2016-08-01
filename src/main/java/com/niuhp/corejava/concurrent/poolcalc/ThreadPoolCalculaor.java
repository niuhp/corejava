package com.niuhp.corejava.concurrent.poolcalc;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by niuhaipeng on 2016/7/29.
 */
public class ThreadPoolCalculaor {
  private TaskProducer taskProducer;
  private double targetUtilization;
  private long targetQueueBytes;

  private int testQueueSize = 1000;
  private BlockingQueueProducer queueProducer = new BlockingQueueProducer() {
    @Override
    public BlockingQueue<Runnable> createWorkQueue() {
      return new LinkedBlockingQueue<Runnable>(testQueueSize);
    }
  };
  private long testTimeMills = 3000;
  private long maxDiffMills = 20;
  private int maxTryCount = 10;

  private static final AtomicBoolean expired = new AtomicBoolean();

  private long usagePerTask;
  private int queueCapacity;
  private long cpuElapsedTime;
  private long cpuComputeTime;
  private long cpuWaitTime;
  private int processors;
  private int threadsCount;

  public ThreadPoolCalculaor(TaskProducer taskProducer) {
    this(taskProducer, 1);
  }

  public ThreadPoolCalculaor(TaskProducer taskProducer, double targetUtilization) {
    this(taskProducer, targetUtilization, 1024 * 1024);
  }

  public ThreadPoolCalculaor(TaskProducer taskProducer, double targetUtilization, long targetQueueBytes) {
    this.taskProducer = taskProducer;
    this.targetUtilization = targetUtilization;
    this.targetQueueBytes = targetQueueBytes;
  }

  public void calculate() {
    calcQueueCapacity();
    Runnable task = taskProducer.createTask();
    runTask(task);
    runTask(task);
    long cpuTime = getCurrentThreadCpuTime();
    runTask(task);
    cpuComputeTime = getCurrentThreadCpuTime() - cpuTime;
    cpuElapsedTime = testTimeMills * 1000000;
    cpuWaitTime = cpuElapsedTime - cpuTime;
    processors = Runtime.getRuntime().availableProcessors();
    threadsCount = new BigDecimal(processors).multiply(
            new BigDecimal(targetUtilization).add(
                    new BigDecimal(cpuWaitTime).divide(new BigDecimal(cpuComputeTime), RoundingMode.HALF_UP)
            )
    ).intValue();
  }

  public void displayResult() {
    StringBuilder resultBuilder = new StringBuilder();
    resultBuilder.append("####################################################################################################################\n")
            .append("target queue memory usage:").append(targetQueueBytes).append(" bytes\n")
            .append("per task[").append(taskProducer.createTask().getClass().getName()).append("] usage:").append(usagePerTask).append(" bytes\n")
            .append("===> recommended queue capacity:").append(targetQueueBytes).append("/").append(usagePerTask).append("=").append(queueCapacity).append("\n")
            .append("---------------------------------------------------------------------------------------------------------------------\n")
            .append("number of processor:").append(processors).append("\n")
            .append("target utilization:").append(targetUtilization).append("\n")
            .append("cpu elapsed time:").append(cpuElapsedTime).append(" nanos\n")
            .append("cpu compute time:").append(cpuComputeTime).append(" nanos\n")
            .append("cpu wait time:").append(cpuWaitTime).append(" nanos\n")
            .append("===> recommended threads count:").append(processors).append("*(")
            .append(targetUtilization).append("+(").append(cpuWaitTime).append("/").append(cpuComputeTime).append("))=")
            .append(threadsCount).append("\n")
            .append("####################################################################################################################\n")
            .append("you can create a thread poll like:\n")
            .append("===> new ThreadPoolExecutor(").append(threadsCount).append(",").append(threadsCount)
            .append(",0,TimeUnit.MILLISECONDS,new ").append(queueProducer.createWorkQueue().getClass().getSimpleName())
            .append("<Runnable>(").append(queueCapacity).append("));\n");
    System.out.println(resultBuilder.toString());
  }

  private void calcQueueCapacity() {
    Queue<Runnable> queue = queueProducer.createWorkQueue();
    for (int i = 0; i < testQueueSize; i++) {
      queue.add(taskProducer.createTask());
    }
    long mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    queue = null;
    callGarbageCollect(15);
    mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    queue = queueProducer.createWorkQueue();
    for (int i = 0; i < testQueueSize; i++) {
      queue.add(taskProducer.createTask());
    }
    mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    usagePerTask = (mem1 - mem0) / testQueueSize;
    queueCapacity = new BigDecimal(targetQueueBytes).divide(new BigDecimal(usagePerTask), RoundingMode.HALF_UP).intValue();
  }

  private void callGarbageCollect(int times) {
    for (int i = 0; i < times; i++) {
      System.gc();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }

  private void runTask(Runnable task) {
    int tryCount = 0;
    long diffMills = 0;
    do {
      if (tryCount > maxTryCount) {
        throw new IllegalStateException("test is not accurate,please run again!");
      }
      expired.set(false);
      long startMills = System.currentTimeMillis();
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          expired.set(true);
        }
      }, testTimeMills);
      while (!expired.get()) {
        task.run();
      }
      long costMills = System.currentTimeMillis() - startMills;
      diffMills = Math.abs(costMills - testTimeMills);
      timer.cancel();
      tryCount++;
    } while (diffMills > maxDiffMills);
    callGarbageCollect(3);
  }

  private long getCurrentThreadCpuTime() {
    return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
  }

  public void setTestQueueSize(int testQueueSize) {
    this.testQueueSize = testQueueSize;
  }

  public void setQueueProducer(BlockingQueueProducer queueProducer) {
    this.queueProducer = queueProducer;
  }

  public void setTestTimeMills(long testTimeMills) {
    this.testTimeMills = testTimeMills;
  }

  public void setMaxDiffMills(long maxDiffMills) {
    this.maxDiffMills = maxDiffMills;
  }

  public void setMaxTryCount(int maxTryCount) {
    this.maxTryCount = maxTryCount;
  }

}
