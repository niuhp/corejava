package com.niuhp.corejava.pattern.state;

import java.awt.Color;

public interface ColorState {

	void handlePush(StateManager sm);

	void handlePoll(StateManager sm);

	Color getColor();
}
