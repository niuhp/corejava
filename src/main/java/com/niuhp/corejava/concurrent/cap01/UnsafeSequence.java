package com.niuhp.corejava.concurrent.cap01;

/**
 * Created by wangj on 2015/7/26.
 */
public class UnsafeSequence implements Sequence {
    private int value;

    @Override
    public int getNext() {
        return value++;
    }
}
