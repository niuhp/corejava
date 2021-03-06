package com.niuhp.corejava.pattern.producer;

import java.security.InvalidParameterException;

public class Market {

	private int max;

	private int current;

	public Market() {
	}

	public Market(int current) {
		this(500, current);
	}

	public Market(int max, int current) {
		if(current<0){
			throw new InvalidParameterException("current can 't be smaller than 0,current="+current);
		}
		
		if(max<=0){
			throw new InvalidParameterException("max can 't be smaller than 1,max="+max);
		}		
		if(current>max){
			throw new InvalidParameterException("current can 't be lager than max,current="+current+",max="+max);
		}
		this.max = max;
		this.current = current;
	}

	public synchronized void produce(int num) {
		while (num + current > max) {
			System.out.println("要生产的产 品数量" + num + "超过剩余库存量" + (max - current) + "，暂时不能执行生产任务!");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		current += num;
		System.out.println("已经生产了" + num + "个产品，现仓储量为" + current);
		notifyAll();
	}

	public synchronized void consume(int num) {
		while (num > current) {
			System.out.println("要消费的产 品数量" + num + "超过当前库存量" + current + "，暂时不能执行消费任务!");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		current -= num;
		System.out.println("已经消费了" + num + "个产品，现仓储量为" + current);
		notifyAll();
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
