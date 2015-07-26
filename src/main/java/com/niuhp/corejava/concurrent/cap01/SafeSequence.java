package com.niuhp.corejava.concurrent.cap01;

/**
 * Created by wangj on 2015/7/26.
 */
public class SafeSequence implements Sequence {
    private int value;

    @Override
    public synchronized int getNext() {
        return value++;
    }
}
