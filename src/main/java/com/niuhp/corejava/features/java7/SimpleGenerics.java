package com.niuhp.corejava.features.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGenerics {

	public void initGenerics() {
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Map<String, Set<String>> map = new HashMap<>();

		list.add("123");
		set.add("456");
		map.put("123", set);
	}
}
