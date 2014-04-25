package com.niuhp.corejava.features.java7;

public class CatchMoreException {

	public void catchMoreException() {
		Object o = "123";
		try {
			int i = Integer.parseInt(o.toString());
			System.out.println(i);
			o.wait();
		} catch (InterruptedException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
