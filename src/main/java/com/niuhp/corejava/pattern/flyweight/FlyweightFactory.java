package com.niuhp.corejava.pattern.flyweight;

public interface FlyweightFactory<K, V extends Flyweight> {
	Flyweight get(K key);
}
