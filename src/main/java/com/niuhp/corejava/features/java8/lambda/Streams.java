package com.niuhp.corejava.features.java8.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {

	public void stream() {
		Collection<Integer> intCollection = new ArrayList<>();
		Stream<Integer> intStream = intCollection.stream();
		intStream.distinct().count();
	}

	public void forEach(Stream<Integer> intStream) {
		intStream.forEach(System.out::println);
	}

	public void filter(Stream<Integer> intStream) {
		intStream.filter((i) -> i > 5);
	}

	public void sorted1(Stream<Integer> intStream) {
		intStream.sorted();
	}

	public void sorted2(Stream<Integer> intStream) {
		intStream.sorted((i, j) -> i - j);
	}

	public void map1(Stream<Integer> intStream) {
		intStream.map((i) -> i + 1);
	}

	public void map2(Stream<Integer> intStream) {
		intStream.map(String::valueOf);
	}

	public void map3(Map<Integer, String> map) {
		map.putIfAbsent(10, "10");
	}

	public void map4(Map<Integer, String> map) {
		map.forEach((key, value) -> System.out.print(String.valueOf(key).equals(value)));
	}

	public void map5(Map<Integer, String> map) {

	}

	public void match1(Stream<Integer> intStream) {
		intStream.anyMatch((i) -> i > 0);
	}

	public void match2(Stream<Integer> intStream) {
		intStream.allMatch((i) -> i > 0);
	}

	public void match3(Stream<Integer> intStream) {
		intStream.noneMatch((i) -> i > 0);
	}

	public void count(Stream<Integer> intStream) {
		intStream.count();
	}

	public void reduce(Stream<Integer> intStream) {
		intStream.reduce((i, j) -> i + j);
	}
}
