/**
 * 
 */
package com.niuhp.corejava.concurrent.cap05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * @author niuhaipeng
 *
 * @date 2015年12月14日
 */
public class CountDownLatchTest {

	@Test
	public void testCountDownLatch() throws InterruptedException {

		int count = 10;

		CountDownLatch latch = new CountDownLatch(count);
		Random ran = new Random();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(ran.nextInt(5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " complete");
				latch.countDown();

			}
		};

		for (int i = 0; i < count; i++) {
			new Thread(r).start();
		}
		System.out.println("----start wait---------");
		latch.await();
		System.out.println("----complete-----------");
	}

	@Test
	public void testIterator() throws InterruptedException {
		List<Double> list = new ArrayList<Double>();
		int itThreadCount = 1000;
		CountDownLatch latch = new CountDownLatch(1);
		for (int i = 0; i < itThreadCount; i++) {
			new Thread() {
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					list.add(Math.random());
					System.out.println(list);
				};
			}.start();
		}

		int waitSec = 5;
		while (waitSec > 0) {
			System.out.println("all threads will process after " + waitSec + " second");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			waitSec--;
		}
		latch.countDown();
		Thread.sleep(5000);
	}
}
