/**
 * 
 */
package com.niuhp.corejava.features.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author niuhaipeng
 *
 * @date 2015年11月26日
 */
public class MultiPortEcho {

	private int[] ports;

	public MultiPortEcho() {

	}

	public MultiPortEcho(int[] ports) {
		this.ports = ports;
	}

	public void startup() throws IOException {
		if (ports == null || ports.length == 0) {
			System.out.println("ports is empty!");
			return;
		}
		Selector selector = Selector.open();
		for (int i = 0; i < ports.length; i++) {
			registerAcceptKey(selector, ports[i]);
		}
		while (true) {
			selector.select();
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while (it.hasNext()) {
				SelectionKey selectionKey = it.next();
				if (selectionKey.isAcceptable()) {
					ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey
							.channel();
					registerReadKey(selector, serverSocketChannel);
				} else if (selectionKey.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) selectionKey
							.channel();
					processSocketChannel(socketChannel);
				}
				it.remove();
			}
		}

	}

	private static void registerAcceptKey(Selector selector, int port)
			throws IOException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket serverSocket = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		serverSocket.bind(address);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("starting to listen on " + port);
	}

	private static void registerReadKey(Selector selector,
			ServerSocketChannel serverSocketChannel) throws IOException {
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ);
		System.out.println("register OP_READ on " + serverSocketChannel);
	}

	private void processSocketChannel(SocketChannel socketChannel)
			throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		int len = -1;
		while (true) {
			len = socketChannel.read(byteBuffer);
			if (len <= 0) {
//				socketChannel.close();
//				System.out.println("read empty bytes,socketChannel["
//						+ socketChannel + "] will be close");
			} else {
				byteBuffer.flip();
				String msg = new String(byteBuffer.array(), 0, len);
				System.out.print(msg);
				byteBuffer.clear();
//				String resMsg = String.format("%s收到消息%s", Thread
//						.currentThread().getName(), msg);
//				ByteBuffer buffer = ByteBuffer.wrap(resMsg.getBytes("GBK"));
//				socketChannel.write(buffer);
			}
		}

	}
}
