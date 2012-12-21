package com.padavala.loom.others;

public class CloningTest {

	public static void main(String[] args){
		
		Cloning object1 = new Cloning(1,1.2f, "first Object");
		System.out.println(object1);
		
		try {
			Cloning object2 = (Cloning) object1.clone();
			System.out.println(object2);
			object2.setMyint(2);
			
			System.out.println(object1);
			System.out.println(object2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
