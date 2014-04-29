package com.niuhp.corejava.features.java7.aio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class SimpleAIOClientWithHandler {
	private final AsynchronousSocketChannel client;

	public SimpleAIOClientWithHandler() throws Exception {
		client = AsynchronousSocketChannel.open();
	}

	public void start() throws Exception {
		SocketAddress address = new InetSocketAddress("localhost", 8888);
		client.connect(address, null, new CompletionHandler<Void, Void>() {
			@Override
			public void completed(Void result, Void attachment) {
				try {
					client.write(ByteBuffer.wrap("test".getBytes())).get();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void failed(Throwable exc, Void attachment) {
				exc.printStackTrace();
			}
		});
		
		client.close();
	}

	public static void main(String args[]) throws Exception {
		new SimpleAIOClientWithHandler().start();
	}

}
