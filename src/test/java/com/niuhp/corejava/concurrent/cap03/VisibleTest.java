/**
 * 
 */
package com.niuhp.corejava.concurrent.cap03;

import org.junit.Test;

/**
 * @author niuhaipeng
 *
 * @date 2015年12月2日
 */
public class VisibleTest {

	private static boolean run = false;
	private static int num = 1;

	@Test
	public void testVisible() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			reset();
			process();
			change();
			Thread.sleep(3000);
		}
	}

	private void process() {
		new Thread() {
			public void run() {
				while (!run) {
					Thread.yield();
				}
				System.out.println(String.format("run=%s,num=%s", run, num));
			};
		}.start();
	}

	private void reset() {
		run = false;
		num = 1;
	}

	private void change() {
		run = true;
		num = 10;
	}
}
