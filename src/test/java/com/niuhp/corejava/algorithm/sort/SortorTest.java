package com.niuhp.corejava.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import com.niuhp.corejava.algorithm.sort.BubbleSortor;
import com.niuhp.corejava.algorithm.sort.SortSolve;
import com.niuhp.corejava.util.ArrayUtil;

public class SortorTest {

	@Test
	public void testSort() {

		SortSolve sortSolve = new SortSolve(new BubbleSortor());

		for (int i = 0; i < 100; i++) {
			int[] array = ArrayUtil.contructArray(1000);
			sortSolve.doSort(array);
			Assert.assertTrue(ArrayUtil.isArraySorted(array));
		}

	}
}
