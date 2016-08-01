package com.niuhp.corejava.concurrent.poolcalc;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2016/8/1.
 */
public class ThreadPoolCalculaorTest {
  @Test
  public void testCalc() {
    ThreadPoolCalculaor poolCalculaor = new ThreadPoolCalculaor(new TaskProducer() {
      @Override
      public Runnable createTask() {
        return new AsyncHttpGetTask("http://126.com");
      }
    });
    poolCalculaor.calculate();
    poolCalculaor.displayResult();
  }
}
