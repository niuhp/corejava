package com.niuhp.corejava.algorithm.sort;

public class HeapSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return;
		}

		buildHeap(array, startIndex, endIndex);
		int temp = array[startIndex];
		array[startIndex] = array[endIndex];
		array[endIndex] = temp;

		sort(array, startIndex, endIndex - 1);

	}

	private void buildHeap(int[] array, int startIndex, int endIndex) {

		int limitIndex = endIndex >> 1;

		for (int index = startIndex; index <= limitIndex; index++) {

			boolean swap = swap(array, index, endIndex);

			if (swap) {
				index = startIndex - 1;
			}

		}

	}

	private boolean swap(int[] array, int index, int endIndex) {

		int lIndex = (index << 1) + 1;

		if (lIndex > endIndex) {
			return false;
		}

		int rIndex = (index << 1) + 2;

		boolean swapLeft = false;
		boolean swapRight = false;

		if (rIndex <= endIndex) {
			if (array[lIndex] > array[index] && array[lIndex] >= array[rIndex]) {
				swapLeft = true;
			} else if (array[rIndex] > array[index]	&& array[rIndex] >= array[lIndex]) {
				swapRight = true;
			}
		} else if (lIndex == endIndex) {
			if (array[lIndex] > array[index]) {
				swapLeft = true;
			}
		}

		if (swapLeft) {
			int temp = array[lIndex];
			array[lIndex] = array[index];
			array[index] = temp;
		}

		if (swapRight) {
			int temp = array[rIndex];
			array[rIndex] = array[index];
			array[index] = temp;
		}

		return swapLeft || swapRight;

	}

}
