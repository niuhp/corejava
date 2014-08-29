package com.niuhp.corejava.util;

import java.util.Random;

public class ArrayUtil {

	public static int[] contructArray(int len) {

		int[] array = new int[len];

		Random ran = new Random();

		for (int i = 0; i < len; i++) {
			array[i] = ran.nextInt(len);
		}

		return array;
	}

	public static void printArray(int[] array, int countPerLine) {

		int len = array.length;

		for (int i = 0; i < len; i++) {
			System.out.print(String.format("%1$3d", array[i]));
			if ((i + 1) % countPerLine == 0) {
				System.out.println();
			}
		}

	}

	public static boolean isArraySorted(int[] array) {
		return isArraySorted(array, 0, array.length - 1);
	}

	public static boolean isArraySorted(int[] array, int startIndex, int endIndex) {

		for (int i = startIndex; i < endIndex; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}

		return true;
	}
}
