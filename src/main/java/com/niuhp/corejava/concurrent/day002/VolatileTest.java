package com.niuhp.corejava.concurrent.day002;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

	public static void main(String[] args) {
		final Counter counter = new Counter();

		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-----before-----" + counter.getNum());
				counter.incr();
				System.out.println("-----after-----" + counter.getNum());
			}
		};

		ExecutorService es = Executors.newFixedThreadPool(100);

		for (int i = 0; i < 100; i++) {
			es.execute(r);
		}

//		System.out.println("-----final-----" + counter.getNum());
	}

}

class Counter {
	private volatile int num;

	public void incr() {
		num++;
	}

	public int getNum() {
		return num;
	}
}
