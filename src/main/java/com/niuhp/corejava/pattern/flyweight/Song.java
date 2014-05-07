package com.niuhp.corejava.pattern.flyweight;

import java.util.Date;

public class Song {

	private Artist artist;

	private Date createDate;

	public Song() {
	}

	public Song(Artist artist, Date createDate) {
		this.artist = artist;
		this.createDate = createDate;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
