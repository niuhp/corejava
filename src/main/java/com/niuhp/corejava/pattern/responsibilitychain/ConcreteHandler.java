package com.niuhp.corejava.pattern.responsibilitychain;

public class ConcreteHandler implements Handler {

	private Handler next;
	private String requestType;

	public ConcreteHandler(String requestType) {
		this(null, requestType);
	}

	public ConcreteHandler(Handler next, String requestType) {
		this.next = next;
		this.requestType = requestType;
	}

	@Override
	public void handleRequest(Request request) {
		if (requestType.equals(request.getRequestType())) {
			request.excute();
		} else if (next != null) {
			next.handleRequest(request);
		} else {
			System.out.println("unsupport requestType:" + request.getRequestType());
		}
	}

}
