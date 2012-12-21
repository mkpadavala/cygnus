package com.padavala.loom.others;

public class Base {
	 
	private int base;

	public Base(int base) {
		this.base = base;
	}

	public Base() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
	
	public void print(){
		System.out.println("baseclass : " + base);	
	}

}
