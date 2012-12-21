package com.padavala.loom.others;

public class CubbyHole {
	
	private static Object lock = new Object();

	private Integer data = 1;
	private boolean availableToRead;
	
	
	public CubbyHole() {
		super();
	}

	public int get() {
		String name = Thread.currentThread().getName();
	//	System.out.println("Thread in get: " + name);
		
		synchronized(lock) {
			while(!availableToRead){
				try{
				//	System.out.println("In get ...Before wait");
					lock.wait();
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
			//System.out.println("In get ...after wait");
			availableToRead = false;
			//lock.notifyAll();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
	}
	
	public  void set(int data1) {
		String name = Thread.currentThread().getName();
		//System.out.println("Thread in set: " + name);

		synchronized(lock) {
		
			while(availableToRead){
				try{
					//System.out.println("In set ...Before wait");
					
					lock.wait();
					
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}	
			}
			//System.out.println("In set ...after wait");

			this.data = data1;
			availableToRead = true;
			
		//	lock.notifyAll();
			
		}
	}	

	public synchronized int get2() {
		String name = Thread.currentThread().getName();
		//System.out.println("Thread in get: " + name);
		availableToRead = false;
		notifyAll();	
		return data;
	}
	
	public  synchronized void set2(int data1)  {
		String name = Thread.currentThread().getName();
		System.out.println("Thread in set: " + name);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.data = data1;
		availableToRead = true;
		notifyAll();
	}	


}
