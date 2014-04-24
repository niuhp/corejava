package com.niuhp.corejava.algorithm.sort;

public class SortSolve {

	private Sortor sortor;

	public SortSolve(Sortor sortor) {
		this.sortor = sortor;
	}

	public void changeSortor(Sortor newSortor) {
		sortor = newSortor;
	}

	public void doSort(int[] array) {
		long t1 = System.currentTimeMillis();
		sortor.sort(array);
		long t2 = System.currentTimeMillis();
		System.out.println(sortor.getClass().getSimpleName() + " costs " + (t2 - t1) + " ms.");
	}

}
