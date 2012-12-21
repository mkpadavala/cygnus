package com.padavala.loom.others;

public class TestStackMin {

	public static void main(String[] args){
		
		StackMin stackMin = new StackMin();
		stackMin.push(2);
		//System.out.println(stackMin.pop());
		stackMin.push(4);
		//System.out.println(stackMin.pop());
		stackMin.push(1);
		//System.out.println(stackMin.pop());
		stackMin.push(5);
		//System.out.println(stackMin.pop());
		stackMin.push(6);
		System.out.println(stackMin.pop());
		stackMin.push(3);
		System.out.println(stackMin.pop());
	}
}
