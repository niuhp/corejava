package com.niuhp.corejava.features.java7;

public class RethrowException {

	public void rethrowException() throws InterruptedException,NumberFormatException {
		Object o = "123";
		try {
			int i = Integer.parseInt(o.toString());
			System.out.println(i);
			o.wait();
		} catch (Exception e) {
			throw e;
		}
	}
}
