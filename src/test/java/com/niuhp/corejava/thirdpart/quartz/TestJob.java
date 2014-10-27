package com.niuhp.corejava.thirdpart.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
	private static final DateFormat DF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("--------" + DF.format(new Date()));

	}

}