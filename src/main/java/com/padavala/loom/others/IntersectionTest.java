package com.padavala.loom.others;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

//import org.junit.Test;

public class IntersectionTest {

	/*
	public static void main(String[] args){

		IntersectionTest test = new IntersectionTest();
		test.testIntersectionOne();
		test.testIntersectionTwo();
		test.testIntersectionThree();
		test.testIntersectionWithnullOne();
		test.testIntersectionWithnullTwo();
	}*/
	
	//@Test
	public void testIntersectionOne(){
		
		List<String> firstList = new ArrayList<String>();
		firstList.add("abc");
		firstList.add("xyz");
		firstList.add("ab");
		firstList.add("abc");
		firstList.add(" ");
		
		List<String> secondList = new ArrayList<String>();
		secondList.add("abc");
		secondList.add("def");
		secondList.add("ab");
		secondList.add("");
		
		/*Intersection intersection = new Intersection();
		Set<String> commonList = intersection.getCommonStrings(firstList, secondList);
		print(firstList, secondList, commonList);
		*/
		//assertEquals(2, commonList == null? -1 : commonList.size() );
	}
	
	//@Test
	public void testIntersectionTwo(){
		
		// same strings in both
		List<String> firstList = new ArrayList<String>();
		firstList.add("abc");
		firstList.add("xyz");
		
		List<String> secondList = new ArrayList<String>();
		secondList.add("abc");
		secondList.add("xyz");
		
		/*Intersection intersection = new Intersection();
		Set<String> commonList = intersection.getCommonStrings(firstList, secondList);
		print(firstList, secondList, commonList);*/
		
		//assertEquals(2, commonList == null? -1 : commonList.size() );
		
	}
	
	//@Test
	public void testIntersectionThree(){
		
		// no intersection
		List<String> firstList = new ArrayList<String>();
		firstList.add("abc");
		firstList.add("xyz");
		
		List<String> secondList = new ArrayList<String>();
		secondList.add("123");
		secondList.add("345were");
		
		/*
		Intersection intersection = new Intersection();
		Set<String> commonList = intersection.getCommonStrings(firstList, secondList);
		print(firstList, secondList, commonList);*/
		
		//assertEquals(0, commonList == null? -1 : commonList.size() );
		
	}
	
	//@Test
	public void testIntersectionWithnullOne(){
		
		// one of the lists is null
		List<String> firstList = new ArrayList<String>();
		firstList.add("abc");
		firstList.add("xyz");
		firstList.add("ab");
		firstList.add("abc");
		firstList.add(" ");
		
		/*
		List<String> secondList = null;
		Intersection intersection = new Intersection();
		Set<String> commonList = intersection.getCommonStrings(firstList, secondList);
		print(firstList, secondList, commonList);
		*/
		//assertEquals(-1, commonList == null? -1 : commonList.size() );
		
	}
	
	//@Test
	public void testIntersectionWithnullTwo(){
		
		//Both the lists are null
		List<String> firstList = null;
		List<String> secondList = null;
		
		/*Intersection intersection = new Intersection();
		Set<String> commonList = intersection.getCommonStrings(firstList, secondList);
		print(firstList, secondList, commonList);
		*/
		//assertEquals(-1, commonList == null? -1 : commonList.size() );
		
	}
	
	
	public static void print(Collection<String> firstList, Collection<String> secondList, Collection<String> commonList){
		print(firstList, "FirstList");
		print(secondList, "SecondList");
		print(commonList, "CommonList");
		System.out.println("=======================");
	}
	public static void print(Collection<String> list, String description){
		
		if(list == null || list.size() == 0){
			System.out.println(description + " : " + "List is Empty");
			return;
		}
		System.out.println(description + " : " + list);
		
	}
	
}
