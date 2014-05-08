package com.niuhp.corejava.pattern.mediator;

import java.util.HashMap;
import java.util.Map;

public class Mediator {

	// 中介者肯定需要保持有若干同事的联系方式
	private Map<String, Colleague> colleagueMap = new HashMap<>();

	// 中介者可以动态地与某个同事建立联系
	public void addColleague(Colleague c) {
		colleagueMap.put(c.getName(), c);
	}

	// 中介者也可以动态地撤销与某个同事的联系
	public void deleteColleague(String name) {
		colleagueMap.remove(name);
	}

	// 中介者必须具备在同事之间处理逻辑、分配任务、促进交流的操作
	public void execute(String name, String otherName) {
		Colleague c = colleagueMap.get(name);
		if (otherName == null) {
			c.doSelf();
		} else {
			c.requestOther(otherName);
		}
	}

}
