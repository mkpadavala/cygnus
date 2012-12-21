package com.padavala.loom.others;


public class ProducerConsumerTest {

	public static void main(String[] args){
		
		
		CubbyHole ch = new CubbyHole();
		
		Producer p = new Producer(ch);
		p.start();
		
		Consumer c = new Consumer(ch);
		c.start();
		
	}
}
