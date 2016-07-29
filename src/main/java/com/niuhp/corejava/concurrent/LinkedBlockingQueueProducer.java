package com.niuhp.corejava.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by niuhaipeng on 2016/7/29.
 */
public class LinkedBlockingQueueProducer implements BlockingQueueProducer {
  @Override
  public BlockingQueue<Runnable> createWorkQueue() {
    return new LinkedBlockingQueue<>();
  }
}
