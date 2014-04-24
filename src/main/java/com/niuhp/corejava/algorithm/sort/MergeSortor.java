package com.niuhp.corejava.algorithm.sort;

public class MergeSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return;
		}

		int mid = (startIndex + endIndex) >> 1;
		sort(array, startIndex, mid);
		sort(array, mid + 1, endIndex);

		int len = endIndex - startIndex + 1;
		int[] tempArray = new int[len];

		int i = startIndex;
		int j = mid + 1;
		int k = 0;

		while (k < tempArray.length) {
			if (i == mid + 1 && j == endIndex + 1) {
				break;
			} else if (i == mid + 1) {
				tempArray[k++] = array[j++];
			} else if (j == endIndex + 1) {
				tempArray[k++] = array[i++];
			} else if (array[i] > array[j]) {
				tempArray[k++] = array[j++];
			} else {
				tempArray[k++] = array[i++];
			}
		}
		System.arraycopy(tempArray, 0, array, startIndex, len);

	}

}
