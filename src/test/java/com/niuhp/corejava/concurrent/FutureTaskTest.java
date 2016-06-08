package com.niuhp.corejava.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by niuhaipeng on 2016/6/8.
 */
public class FutureTaskTest {
  @Test
  public void testTimeout() {
    RandomSleepTask task = new RandomSleepTask(2000);
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    int total = 10;
    List<FutureTask> taskList = new ArrayList<>();
    for (int i = 0; i < total; i++) {
      FutureTask futureTask = new FutureTask(task, null);
      executorService.execute(futureTask);
      taskList.add(futureTask);
    }
    System.out.println("--------------------------------------submit-----------------------------------------------------");
    for (int i = 0; i < total; i++) {
      FutureTask futureTask = taskList.get(i);
      try {
        futureTask.get(1000, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        System.out.println("---------InterruptedException-------");
      } catch (ExecutionException e) {
        System.out.println("---------ExecutionException-------");
      } catch (TimeoutException e) {
        System.out.println("---------timeout-------");
        futureTask.cancel(true);
      }
    }
  }
}
