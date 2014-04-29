package com.niuhp.corejava.features.java7.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class SimpleAIOClientWithFurture {
	private final AsynchronousSocketChannel client;

	public SimpleAIOClientWithFurture() throws IOException {
		client = AsynchronousSocketChannel.open();
	}

	public void sendMsg() throws InterruptedException, ExecutionException, IOException {
		SocketAddress address = new InetSocketAddress("localhost", 8888);
		client.connect(address);

		client.write(ByteBuffer.wrap("test".getBytes())).get();
		client.close();
	}

	public static void main(String... args) throws Exception {
		SimpleAIOClientWithFurture client = new SimpleAIOClientWithFurture();
		client.sendMsg();
	}

}
