package com.padavala.loom.others;

public class IncrementNumber {

	/**
	 * Given a number, e.g., 2789, as an array [2,7,8,9].
	 *  Write a method that returns the array incremented by one: i.e. [2,7,9,0].
	 */
	public static void main(String[] args){
		
		int[] array = {9,9,9,9};
		print(array);
		for(int i=array.length-1; i>=0; i--){
			if(((array[i]+1) %10) == 0){
				array[i]=0;
			}else{
				array[i]= array[i]+1;
				break;
			}
		}
		print(array);
		
	}
	
	private static void print(int[] array){
	
		for(int i : array){
			System.out.print(i);
		}
		System.out.println();
	}
}
