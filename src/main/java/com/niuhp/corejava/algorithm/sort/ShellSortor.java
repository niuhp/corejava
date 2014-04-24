package com.niuhp.corejava.algorithm.sort;

public class ShellSortor extends Sortor {

	@Override
	public void sort(int[] array, int startIndex, int endIndex) {

		int len = endIndex - startIndex + 1;

		int incr = len >> 1;

		while (incr >= 1) {

			for (int i = 0; i < incr; i++) {

				for (int j = startIndex + incr + i; j <= endIndex; j += incr) {

					int temp = array[j];
					int k = j - incr;

					while (k >= startIndex + i && array[k] > temp) {
						array[k + incr] = array[k];
						k -= incr;
					}
					if (k != j - incr) {
						array[k + incr] = temp;
					}

				}
			}

			incr >>= 1;
		}

	}

}
