package com.padavala.loom.others;

public class Cloning implements Cloneable{
	
	int myint;
	float myfloat;
	String myString;
	
	
	public Cloning(int myint, float myfloat, String myString) {
		super();
		this.myint = myint;
		this.myfloat = myfloat;
		this.myString = myString;
	}
	
	
	public int getMyint() {
		return myint;
	}
	public void setMyint(int myint) {
		this.myint = myint;
	}
	public float getMyfloat() {
		return myfloat;
	}
	public void setMyfloat(float myfloat) {
		this.myfloat = myfloat;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}


	@Override
	public String toString() {
		return "Cloning [myint=" + myint + ", myfloat=" + myfloat
				+ ", myString=" + myString + "]";
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
