package com.padavala.loom.others;

public class TestMain {
	
	public static void main(String[] args){
		String str = "Cutie Pie ...";
		//printBytes(str);
		//reverseString(str);
		System.out.println(reverseStringRecursion(str));
	}
	
	public static String reverseStringRecursion(String str){
		
		if(str.length() == 1){
			return str;
		}
		return reverseStringRecursion(str.substring(1, str.length())) + str.charAt(0);
		
	}
	
	public static void reverseString(String str){
		System.out.println(str);
		byte[] bytearr = str.getBytes();
		for(int i=0, j=bytearr.length-1; i<j ; i++, j--){
			byte temp = bytearr[i];
			bytearr[i]=bytearr[j];
			bytearr[j]=temp;
		}
		String newstr = new String(bytearr);
		System.out.println(newstr);
		
	}
	
	public static void printBytes(String str){
		System.out.println(str.length());
		byte b[]=str.getBytes();
		for(int i=0;i<b.length;i++)
		System.out.println((char)b[i]);

	}

}
