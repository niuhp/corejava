package com.niuhp.corejava.concurrent;

/**
 * Created by niuhaipeng on 2016/7/29.
 */
public interface TaskProducer {
  Runnable createTask();
}
