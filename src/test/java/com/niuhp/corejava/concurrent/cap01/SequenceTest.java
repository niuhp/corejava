package com.niuhp.corejava.concurrent.cap01;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangj on 2015/7/26.
 */
public class SequenceTest {

    private ExecutorService executorService;
    private Runnable sequenceRunnable;

    @Before
    public void init() {
        executorService = Executors.newFixedThreadPool(20);
        Sequence sequence = new UnsafeSequence();
//        Sequence sequence = new SafeSequence();
        sequenceRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("next value is " + sequence.getNext());
            }
        };
    }

    @Test
    public void testGetNext() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            executorService.execute(sequenceRunnable);
        }

        Thread.sleep(600000);

    }
}
