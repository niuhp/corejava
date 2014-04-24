package com.niuhp.corejava.pattern.state;

import java.awt.Color;

public class BlueState implements ColorState {

	public void handlePoll(StateManager sm) {
		sm.setColorState(new GreenState());

	}

	public void handlePush(StateManager sm) {
		sm.setColorState(new RedState());

	}

	public Color getColor() {

		return Color.BLUE;
	}
}
