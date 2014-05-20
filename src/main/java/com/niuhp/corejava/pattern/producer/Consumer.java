package com.niuhp.corejava.pattern.producer;

public class Consumer extends Role {

	public Consumer(Market market) {
		super(market);
	}

	private void consume(int num) {
		market.consume(num);
	}

	private void consume() {
		int num = RAN.nextInt(20)+1;
		consume(num);

	}

	@Override
	public void run() {
		consume();
	}
}
