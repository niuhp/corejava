package com.niuhp.corejava.features.java7.forkjoin;

import java.util.concurrent.RecursiveAction;

public class BiSearchWithForkJoin extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int threshold;
	private final BinarySearchProblem problem;
	public int result;
	private final int numberToSearch;

	public BiSearchWithForkJoin(BinarySearchProblem problem, int threshold, int numberToSearch) {
		this.problem = problem;
		this.threshold = threshold;
		this.numberToSearch = numberToSearch;
	}

	@Override
	protected void compute() {
		if (problem.size < threshold) { // 小于阀值，就直接用普通的二分查找
			result = problem.searchSequentially(numberToSearch);
		} else {
			// 分解子任务
			int midPoint = problem.size / 2;
			BiSearchWithForkJoin left = new BiSearchWithForkJoin(problem.subProblem(0, midPoint), threshold,
					numberToSearch);
			BiSearchWithForkJoin right = new BiSearchWithForkJoin(problem.subProblem(midPoint + 1, problem.size),
					threshold, numberToSearch);
			invokeAll(left, right);
			result = Math.max(left.result, right.result);
		}
	}
}
