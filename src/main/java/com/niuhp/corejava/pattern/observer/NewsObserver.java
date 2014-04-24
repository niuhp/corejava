package com.niuhp.corejava.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class NewsObserver implements Observer {

	private static int index = 1;

	public void update(Observable o, Object arg) {
		if (arg instanceof String) {
			String newsTitle = (String) arg;
			System.out.println("receive the " + (index++) + " +news:" + newsTitle);
		}
	}
}
