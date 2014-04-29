package com.niuhp.corejava.features.java7.nio2_0;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatcherExample {

	@SuppressWarnings("unchecked")
	private static void handleEvent(Path path, WatchService watchService) throws InterruptedException, IOException {
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);

		while (true) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				Kind<?> kind = event.kind();
				if (kind == StandardWatchEventKinds.OVERFLOW) {
					continue;
				}
				WatchEvent<Path> e = (WatchEvent<Path>) event;
				Path fileName = e.context();

				System.out.printf("Event %s has happened,which fileName is %s%n", kind.name(), fileName);
			}
			if (!key.reset()) {
				break;
			}
		}

	}

	public static void watchPath(String dirPath) throws IOException, InterruptedException {
		Path path = Paths.get(dirPath);
		WatchService ws = FileSystems.getDefault().newWatchService();
		handleEvent(path, ws);
	}

//	public static void main(String[] args) {
//		try {
//			watchPath("d:/temp");
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
}
