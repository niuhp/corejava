package com.niuhp.corejava.pattern.state;

public class StateManager {

	private ColorState colorState;

	public ColorState getColorState() {
		return colorState;
	}

	public void setColorState(ColorState colorState) {
		this.colorState = colorState;
	}

	public void push() {
		colorState.handlePush(this);
		System.out.println("-----current color is " + colorState.getColor());
	}

	public void poll() {
		colorState.handlePoll(this);
		System.out.println("-----current color is " + colorState.getColor());
	}

}
