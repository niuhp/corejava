package com.niuhp.corejava.pattern.flyweight;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class FlyweightTest {

	@Test
	public void testFlyweight() {
		ArtistFactory af = ArtistFactory.createArtistFactory();

		Artist a1 = af.get("LiuDehua");
		Artist a2 = af.get("LiuDehua");
		Artist a3 = af.get("LiuDehua");

		Song s1 = new Song(a1, new Date());
		Song s2 = new Song(a2, new Date());
		Song s3 = new Song(a3, new Date());

		Assert.assertTrue(s1.getArtist() == s2.getArtist());
		Assert.assertTrue(s1.getArtist() == s3.getArtist());
	}
}
