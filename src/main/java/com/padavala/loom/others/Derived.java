package com.padavala.loom.others;

public class Derived extends Base{

	private int derived;

	public int getDerived() {
		return derived;
	}

	public void setDerived(int derived) {
		this.derived = derived;
	}

	public Derived(int base, int derived) {
		this.derived = derived;
	}
	
	public void print(){
		//super.print();
		System.out.println("derived class : " + derived);
	}

	
}
