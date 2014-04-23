package com.niuhp.corejava.sort;

public class BubbleSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {
		int len = endIndex - startIndex + 1;
		for (int i = 1; i < len; i++) {
			for (int j = startIndex; j < endIndex - i + 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
