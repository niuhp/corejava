package com.niuhp.corejava.pattern.state;

import java.awt.Color;

public class GreenState implements ColorState {

	public void handlePush(StateManager sm) {
		sm.setColorState(new BlueState());

	}

	public void handlePoll(StateManager sm) {
		sm.setColorState(new RedState());

	}

	public Color getColor() {

		return Color.GREEN;
	}

}
