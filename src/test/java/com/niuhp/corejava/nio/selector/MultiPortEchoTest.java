/**
 * 
 */
package com.niuhp.corejava.nio.selector;

import java.io.IOException;

import org.junit.Test;

import com.niuhp.corejava.features.nio.selector.MultiPortEcho;

/**
 * @author niuhaipeng
 *
 * @date 2015年11月26日
 */
public class MultiPortEchoTest {

	@Test
	public void testStartup() throws IOException {
		MultiPortEcho mp = new MultiPortEcho(new int[] { 5801, 5802, 5803 });
		mp.startup();
	}
}
