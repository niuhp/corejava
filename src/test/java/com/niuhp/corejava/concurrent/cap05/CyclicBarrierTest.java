/**
 * 
 */
package com.niuhp.corejava.concurrent.cap05;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

/**
 * @author niuhaipeng
 *
 * @date 2016年1月6日
 */
public class CyclicBarrierTest {

	@Test
	public void testCyclicBarrier() {
		int count = 10;

		Runnable action = new Runnable() {

			@Override
			public void run() {
				System.out.println("---------complete----------");

			}
		};
		CyclicBarrier cb = new CyclicBarrier(count, action);

		Random ran = new Random();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(ran.nextInt(5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " complete");
				try {
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < count; i++) {
			new Thread(task).start();
		}
		System.out.println("----start wait---------");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
