package com.niuhp.corejava.base;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.niuhp.corejava.base.stacktrace.StackTraceUtil;

public class StackTraceTest {

	@Test
	public void testRedirectStackTrace() throws FileNotFoundException {

		StackTraceUtil.setErr("D:/temp/log_error.log");
		try {
			Integer.parseInt("55sd5f");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
