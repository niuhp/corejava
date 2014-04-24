package com.niuhp.corejava.pattern.state;

import java.awt.Color;

public class RedState implements ColorState {

	public void handlePush(StateManager sm) {
		sm.setColorState(new GreenState());

	}

	public void handlePoll(StateManager sm) {
		sm.setColorState(new BlueState());

	}

	public Color getColor() {

		return Color.RED;
	}

}
