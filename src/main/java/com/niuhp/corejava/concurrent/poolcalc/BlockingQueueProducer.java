package com.niuhp.corejava.concurrent.poolcalc;

import java.util.concurrent.BlockingQueue;

/**
 * Created by niuhaipeng on 2016/7/29.
 */
public interface BlockingQueueProducer {
  BlockingQueue<Runnable> createWorkQueue();
}
