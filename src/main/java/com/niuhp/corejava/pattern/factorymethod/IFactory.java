package com.niuhp.corejava.pattern.factorymethod;


public class IFactory {

	public static ISample createSample(String className) {

		if (className != null) {
			switch (className) {
			case "Sample1":
				return new Sample1();
			case "Sample2":
				return new Sample2();
			default:
				System.out.println(className + " is not supported yet !");
			}
		}
		return null;
	}
}
