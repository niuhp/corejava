package com.niuhp.corejava.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ArtistFactory implements FlyweightFactory<String, Artist> {

	private Map<String, Artist> artistPool = new HashMap<>();

	private static int addrIndex = 1;
	private Random ran = new Random();

	private ArtistFactory() {
	}

	public static ArtistFactory createArtistFactory() {
		return new ArtistFactory();
	}

	@Override
	public Artist get(String name) {
		Artist artist = artistPool.get(name);
		if (artist == null) {
			artist = new Artist(name, "addr" + addrIndex, ran.nextInt(20) + 20);
			artistPool.put(name, artist);
		}
		return artist;
	}

}
