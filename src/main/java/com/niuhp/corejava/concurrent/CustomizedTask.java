/**
 * 
 */
package com.niuhp.corejava.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author niuhaipeng
 *
 * @date 2016年1月11日
 */
public class CustomizedTask implements Runnable {

	@Override
	public void run() {
		beforeExcute();
		doExcute();
		afterExcute();
	}

	protected void beforeExcute() {
		String threadName = Thread.currentThread().getName();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
		System.out.println(String.format("%s excute task start at %s", threadName, df.format(new Date())));
	}

	protected void doExcute() {

	}

	protected void afterExcute() {
		String threadName = Thread.currentThread().getName();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
		System.out.println(String.format("%s excute task complete at %s", threadName, df.format(new Date())));
	}
}
