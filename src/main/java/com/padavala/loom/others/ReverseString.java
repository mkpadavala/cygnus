package com.padavala.loom.others;

public class ReverseString {

	
	public static String reverse(String input){
		if(input== null || input.length() == 1){
			return input;
		}
		return reverse(input.substring(1)) + input.charAt(0);
	}
	
	public static String reverseUsingBytes(String input){
		if(input== null || input.length() <=1){
			return input;
		}
		byte temp;
		byte[] inputBytes= input.getBytes();
		for(int start=0, end=inputBytes.length-1; start<end; start++,end--){
			temp=inputBytes[start];
			inputBytes[start]=inputBytes[end];
			inputBytes[end]=temp;
		}
		return new String(inputBytes);
	}
	
	public static String reverseUsingChars(String input){
		if(input== null || input.length() <=1){
			return input;
		}
		char temp;
		char[] charArray= input.toCharArray();
		for(int start=0, end=charArray.length-1; start<end; start++,end--){
			temp=charArray[start];
			charArray[start]=charArray[end];
			charArray[end]=temp;
		}
		return new String(charArray);
	}
	
	
	
	public static void main(String[] args) {
		String test = "Murali";
		System.out.println(reverse(test));
		System.out.println(reverseUsingBytes(test));
		System.out.println(reverseUsingChars(test));
	}

}
