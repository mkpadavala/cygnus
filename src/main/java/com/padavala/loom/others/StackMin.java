package com.padavala.loom.others;

import java.util.Stack;

public class StackMin extends Stack<Integer>{

	Stack<Integer> s1;
	Stack<Integer> min;
	
	public StackMin(){
		s1= new Stack<Integer>();
		min= new Stack<Integer>();
	}
	
	
	public void push(int value){
		if(value <= min()){
			min.push(value);
		}
		s1.push(value);
	}
	
	public Integer pop(){
		if(!s1.isEmpty() &&  s1.peek() > min()){
			min.pop();
		}
		return s1.pop();
	}
	
	public int  min(){
		if(min.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return min.peek();
		}
	}
}
