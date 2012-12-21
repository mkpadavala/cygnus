package com.padavala.loom.others;

public class Producer extends Thread{
	
	private CubbyHole cubbyHole;

	public Producer(CubbyHole cubbyHole) {
		this.cubbyHole = cubbyHole;
	}

	public void run() {
		for(int i=0; i< 5; i++){
			cubbyHole.set(i);
			System.out.println("Producer - " + this.getName() + " : " + i);
		}
		
	}

}
