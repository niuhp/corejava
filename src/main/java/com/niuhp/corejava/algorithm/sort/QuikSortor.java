package com.niuhp.corejava.algorithm.sort;

public class QuikSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return;
		}

		int i = startIndex;
		int j = endIndex;
		int temp = array[i];

		while (i < j) {

			while (i < j && array[j] > temp) {
				j--;
			}
			array[i] = array[j];

			while (i < j && array[i] <= temp) {
				i++;
			}
			array[j] = array[i];

		}

		array[i] = temp;
		sort(array, startIndex, i - 1);
		sort(array, i + 1, endIndex);

	}

}
