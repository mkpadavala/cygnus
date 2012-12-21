package com.padavala.loom.others;

public class Consumer extends Thread {
	
	private CubbyHole cubbyHole;

	public Consumer(CubbyHole cubbyHole) {
		this.cubbyHole = cubbyHole;
	}

	public void run(){
		for(int i=0; i<5; i++){
			System.out.println("Consumer - " + this.getName() +" : "+ cubbyHole.get());
		}
	}
}
