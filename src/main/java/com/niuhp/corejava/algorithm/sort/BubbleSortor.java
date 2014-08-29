package com.niuhp.corejava.algorithm.sort;

public class BubbleSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		for (int i = startIndex; i < endIndex; i++) {

			for (int j = startIndex; j <  endIndex + startIndex - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}

	}
}
