package com.niuhp.corejava.pattern.decorator;

public class Downloador implements Download {

	private Download download;

	public Downloador(Download download) {
		this.download = download;
	}

	public void doJob() {
		beforeDoJob();
		download.doJob();
		afterDoJob();
	}

	protected void beforeDoJob() {

	}

	protected void afterDoJob() {

	}
}
