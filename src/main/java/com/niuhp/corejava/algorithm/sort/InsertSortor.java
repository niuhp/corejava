package com.niuhp.corejava.algorithm.sort;

public class InsertSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		for (int i = startIndex + 1; i <= endIndex; i++) {

			int temp = array[i];
			int j = i - 1;

			while (j >= startIndex && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			if (j != i - 1) {
				array[j + 1] = temp;
			}

		}

	}

}
