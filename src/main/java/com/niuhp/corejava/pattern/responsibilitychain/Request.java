package com.niuhp.corejava.pattern.responsibilitychain;

public class Request {

	private boolean excuted;

	private String requestType;

	public Request(String requestType) {
		this.requestType = requestType;
	}

	public void excute() {
		if (excuted) {
			throw new IllegalStateException("Request had been excuted !");
		}
		System.out.println("excute " + requestType + " request !");
		excuted = true;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
