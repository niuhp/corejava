/**
 * 
 */
package com.niuhp.corejava.concurrent;

import java.util.Random;

/**
 * @author niuhaipeng
 *
 * @date 2016年1月11日
 */
public class RandomSleepTask extends CustomizedTask {

	private int millsBound;

	public RandomSleepTask(int millsBound) {
		this.millsBound = millsBound;
	}

	protected void doExcute() {
		if (millsBound <= 0) {
			return;
		}
		String threadName = Thread.currentThread().getName();
		Random random = new Random();
		long mills = random.nextInt(millsBound);
		System.out.println(String.format("%s excute task with sleep %s mills", threadName, mills));
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
