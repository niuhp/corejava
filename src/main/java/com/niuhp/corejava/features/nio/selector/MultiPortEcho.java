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
	private final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

	public MultiPortEcho() {

	}

	public MultiPortEcho(int[] ports) {
		this.ports = ports;
	}

	public void startup1() throws IOException {
		if (ports == null || ports.length == 0) {
			System.out.println("ports is empty!");
			return;
		}
		Selector selector = Selector.open();
		for (int i = 0; i < ports.length; ++i) {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(ports[i]);
			ss.bind(address);
			SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Going to listen on " + ports[i] + " with interestOps=" + key.interestOps());
		}

		while (true) {
			int num = selector.select();
			System.out.println("selector.select is " + num);
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					// Accept the new connection
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					// Add the new connection to the selector
					SelectionKey newKey = sc.register(selector, SelectionKey.OP_READ);
					it.remove();
					System.out.println("Got connection from " + sc + " with key=" + newKey);
				} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
					// Read the data
					SocketChannel sc = (SocketChannel) key.channel();
					// Echo data
					int bytesEchoed = 0;
					while (true) {
						byteBuffer.clear();

						int number_of_bytes = sc.read(byteBuffer);
						if (number_of_bytes <= 0) {
							break;
						}
						byteBuffer.flip();
						sc.write(byteBuffer);
						bytesEchoed += number_of_bytes;
					}
					System.out.println("Echoed " + bytesEchoed + " from " + sc);
					it.remove();
				}
			}
		}
	}
}
