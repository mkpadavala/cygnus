package com.padavala.loom.others;

public class SampleThread implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new SampleThread()).start();
	}

	public void run(){
		try {
			System.out.println(this + "started sleeping..");
			Thread.sleep(5000);
			System.out.println(this + "woke up and out ...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
