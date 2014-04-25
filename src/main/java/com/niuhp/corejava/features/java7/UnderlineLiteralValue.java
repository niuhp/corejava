package com.niuhp.corejava.features.java7;

public class UnderlineLiteralValue extends BinaryLiteralValue {

	@Override
	public void initProperties() {
		binary = 0b11_1010_0001;
		octonary = 07_123;
		decimalism = 17_1234;
		hexadecimal = 0x888_f;
	}

}
