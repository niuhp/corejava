package com.niuhp.corejava.features.java7.nio2_0;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class EzFileVisitor extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		find(dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		find(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		find(file);
		return FileVisitResult.CONTINUE;
	}

	private void find(Path path) {
		String typeStr = Files.isDirectory(path) ? "目录" : "文件";
		System.out.printf("访问-%s:%s%n", typeStr, path.getFileName());
	}

//	public static void main(String[] args) throws IOException {
//		Path path = Paths.get("d:/temp");
//		FileVisitor<Path> fileVisitor = new EzFileVisitor();
//		Files.walkFileTree(path, fileVisitor);
//	}
}
