package com.niuhp.corejava.concurrent.threadscalc;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by niuhaipeng on 2016/7/22.
 */
public class SimplePoolSizeCaculatorImpl extends PoolSizeCalculator {
  @Override
  protected Runnable creatTask() {
    return new AsyncIOTask();
  }

  @Override
  protected BlockingQueue<Runnable> createWorkQueue() {
    return new LinkedBlockingQueue<Runnable>(1000);
  }

  @Override
  protected long getCurrentThreadCPUTime() {
    return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
  }

  public static void main(String[] args) {
    PoolSizeCalculator poolSizeCalculator = new SimplePoolSizeCaculatorImpl();
    poolSizeCalculator.calculateBoundaries(new BigDecimal(1.0), new BigDecimal(100000));
  }
}
