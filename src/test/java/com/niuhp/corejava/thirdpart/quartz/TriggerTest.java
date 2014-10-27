package com.niuhp.corejava.thirdpart.quartz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerTest {

	private Scheduler scheduler;
	private JobDetail jobDetail;
	private Trigger trigger;

	@Before
	public void init() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		scheduler = sf.getScheduler();
		jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("testJob", "testGroup").build();
	}

	@Test
	public void testCronTrigger() {
		trigger = TriggerBuilder.newTrigger()
				.withIdentity("testJob", "testGroup").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("*/15 * * * * ?")).build();
	}

	@Test
	public void testSimpleTrigger() throws SchedulerException {
		trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("testJob", "testGroup")
				.startNow()
				.withSchedule(
						SimpleScheduleBuilder
								.simpleSchedule()
								.withRepeatCount(
										SimpleTrigger.REPEAT_INDEFINITELY)
								.withIntervalInSeconds(10)).build();

		excute();
	}

	@After
	public void excute() throws SchedulerException {
		scheduler.scheduleJob(jobDetail, trigger);

		scheduler.start();

		try {
			Thread.sleep(60 * 1000 * 60 * 24);
		} catch (Exception e) {

		}
	}

}
