package com.niuhp.corejava.features.java7;

public class BinaryLiteralValue {

	protected int binary;

	protected int octonary;

	protected int decimalism;

	protected int hexadecimal;

	public BinaryLiteralValue() {

	}

	public void initProperties() {
		binary = 0b111;// only java7 or later support
		octonary = 01234567;
		decimalism = 123456789;
		hexadecimal = 0xabcdef;
	}

}
