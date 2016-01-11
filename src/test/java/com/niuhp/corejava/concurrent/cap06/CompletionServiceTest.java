/**
 * 
 */
package com.niuhp.corejava.concurrent.cap06;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.niuhp.corejava.concurrent.RandomSleepTask;

/**
 * @author niuhaipeng
 *
 * @date 2016年1月11日
 */
public class CompletionServiceTest {

	@Test
	public void testCompletionService() {
		Executor executor = Executors.newCachedThreadPool();
		CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor);

		int taskCount = 5;
		for (int i = 0; i < taskCount; i++) {
			completionService.submit(new RandomSleepTask(20000), null);
		}

		for (int i = 0; i < taskCount; i++) {
			try {
				Future<Void> future = completionService.take();
				Void result = future.get();
				System.out.println(String.format("result=%s", result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
