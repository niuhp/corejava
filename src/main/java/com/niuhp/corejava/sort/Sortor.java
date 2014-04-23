package com.niuhp.corejava.sort;

public abstract class Sortor {

	public final void sort(int[] array){
		sort(array, 0, array.length-1);
	}
	
	public abstract void sort(int[] array,int startIndex,int endIndex);
}
