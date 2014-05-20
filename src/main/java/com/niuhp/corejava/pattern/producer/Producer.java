package com.niuhp.corejava.pattern.producer;

public class Producer extends Role {

	public Producer(Market market) {
		super(market);
	}

	private void produce(int num) {
		market.produce(num);
	}

	private void produce() {
		int num = RAN.nextInt(20)+1;
		produce(num);

	}

	@Override
	public void run() {
		produce();

	}

}
