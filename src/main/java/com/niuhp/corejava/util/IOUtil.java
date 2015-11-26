/**
 * 
 */
package com.niuhp.corejava.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author niuhaipeng
 *
 * @date 2015年11月26日
 */
public class IOUtil {

	private IOUtil() {
	}

	public static void close(Closeable closeable) {
		if (closeable == null) {
			return;
		}
		try {
			closeable.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
