package com.niuhp.corejava.base;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.niuhp.corejava.base.stacktrace.SystemStreamUtil;

public class StackTraceTest {

	@Test
	public void testRedirectStackTrace() throws FileNotFoundException {

		SystemStreamUtil.redirectErr("D:/temp/log_error.log");
		try {
			Integer.parseInt("55sd5f");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
