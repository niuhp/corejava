package com.niuhp.corejava.base.stacktrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class StackTraceUtil {

	private StackTraceUtil() {
	}

	public static void setErr(PrintStream err) {
		System.setErr(err);
	}

	public static void setErr(File errFile) {
		createFileIfNotExists(errFile);
		try {
			PrintStream err = new PrintStream(new FileOutputStream(errFile, true));
			setErr(err);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void setErr(String filePath) {
		File file = new File(filePath);
		setErr(file);
	}

	public static void setOut(PrintStream out) {
		System.setOut(out);
	}

	public static void setOut(File outFile) {
		createFileIfNotExists(outFile);
		try {
			PrintStream out = new PrintStream(new FileOutputStream(outFile, true));
			setOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void setOut(String filePath) {
		File file = new File(filePath);
		setOut(file);
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
