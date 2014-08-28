package com.niuhp.corejava.concurrent.day001;

public class Code3_1 {

	private static boolean ready;
	private static int number;

	public static void main(String[] args){
		Runnable r = new Runnable() {

			@Override
			public void run() {
				while (!ready) {
					System.out.println("-----yield------");
					Thread.yield();
				}
				System.out.println("-----number------" + number);
			}
		};

		Thread readerThread = new Thread(r);
		readerThread.start();
				
		number = 100;
		ready = true;
	}

}
