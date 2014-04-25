package com.niuhp.corejava.features.java7.nio2_0;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemMethod {

	public void operatePath() {
		URI uri;
		try {
			uri = new URI("d:/temp");
			Path path = Paths.get(uri);
			path.toFile();
			// operations of Path....
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public void operateFile() {

		// operatons of Files

	}
}
