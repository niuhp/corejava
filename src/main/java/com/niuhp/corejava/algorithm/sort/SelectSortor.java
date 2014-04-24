package com.niuhp.corejava.algorithm.sort;

public class SelectSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		for (int i = startIndex; i < endIndex; i++) {

			int minIndex = i;

			for (int j = i + 1; j <= endIndex; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}

		}

	}

}
