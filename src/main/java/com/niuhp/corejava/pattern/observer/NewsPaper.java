package com.niuhp.corejava.pattern.observer;

import java.util.Observable;

public class NewsPaper extends Observable {

	public void publishNews(String newsTitle) {
		System.out.println("----publish news----" + newsTitle);
		setChanged();
		notifyObservers(newsTitle);
	}
}
