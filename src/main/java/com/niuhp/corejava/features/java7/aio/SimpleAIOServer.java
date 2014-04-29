package com.niuhp.corejava.features.java7.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleAIOServer {
	private AsynchronousServerSocketChannel server;

	public SimpleAIOServer() throws IOException {
		SocketAddress address = new InetSocketAddress(8888);
		server = AsynchronousServerSocketChannel.open().bind(address);
	}

	public void start() throws InterruptedException, ExecutionException, TimeoutException, IOException {
		Future<AsynchronousSocketChannel> future = server.accept();
		AsynchronousSocketChannel socket = future.get();

		ByteBuffer readBuf = ByteBuffer.allocate(1024);
		socket.read(readBuf).get(100, TimeUnit.SECONDS);

		System.out.printf("Receiver:%s%n", new String(readBuf.array()));
		server.close();
	}

	public static void main(String args[]) throws Exception {
		new SimpleAIOServer().start();
	}

}
