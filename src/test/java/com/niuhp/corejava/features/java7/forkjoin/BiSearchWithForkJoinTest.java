package com.niuhp.corejava.features.java7.forkjoin;

import java.util.concurrent.ForkJoinPool;

import org.junit.Before;
import org.junit.Test;

public class BiSearchWithForkJoinTest {

	public int[] data;

	@Before
	public void init() {
		data = new int[1000_0000];
		for (int i = 0; i < data.length; i++) {
			data[i] = i;
		}

	}

	@Test
	public void testForkjoin() {

		BinarySearchProblem problem = new BinarySearchProblem(data, 0, data.length);
		int threshold = 100;
		int nThreads = 10;
		// 查找100_0000所在的下标
		BiSearchWithForkJoin bswfj = new BiSearchWithForkJoin(problem, threshold, 100_0000);
		ForkJoinPool fjPool = new ForkJoinPool(nThreads);
		fjPool.invoke(bswfj);
		System.out.printf("Result is:%d%n", bswfj.result);

	}
}
