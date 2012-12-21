package com.padavala.loom.others;

public class Recursion {

	private static int counter;
	
	public Recursion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		new Recursion().recurse();
		
	}
	
	public void recurse(){
		
		if(counter == 5){
			System.exit(0);
		}
		
		System.out.println(++counter);
		recurse();
		
	}
}
