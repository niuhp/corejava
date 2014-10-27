package com.niuhp.corejava.base.stacktrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SystemStreamUtil {

	private SystemStreamUtil() {
	}

	public static void redirectErr(PrintStream err) {
		System.setErr(err);
	}

	public static void redirectErr(File errFile) {
		createFileIfNotExists(errFile);
		try {
			PrintStream err = new PrintStream(new FileOutputStream(errFile, true));
			redirectErr(err);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void redirectErr(String filePath) {
		File file = new File(filePath);
		redirectErr(file);
	}

	public static void redirectOut(PrintStream out) {
		System.setOut(out);
	}

	public static void redirectOut(File outFile) {
		createFileIfNotExists(outFile);
		try {
			PrintStream out = new PrintStream(new FileOutputStream(outFile, true));
			redirectOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void redirectOut(String filePath) {
		File file = new File(filePath);
		redirectOut(file);
	}

	private static void createFileIfNotExists(File file) {
		if (file == null) {
			return;
		}
		if (file.exists()) {
			return;
		}
		File dir = file.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
