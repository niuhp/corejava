package com.niuhp.corejava.features.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public void readFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(""))) {
			br.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
