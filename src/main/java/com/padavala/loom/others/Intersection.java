package com.padavala.loom.others;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

	public Set<String> getCommonStrings(List<String> firstList, List<String> secondList) {
		
		//space complexity O(min(m,n)
		// time complexity O(m+n) average.
		// where m = firstList.size(); n=secondList.size();
		
		if(firstList == null || firstList.size() == 0 || secondList == null || secondList.size() == 0 ){
			return null;
		}
		
		Set<String> set = null;
		List<String> listToIterate = null;
		Set<String> intersection = new HashSet<String>();
		if(firstList.size() < secondList.size()){
			set = new HashSet<String>(firstList.size()); // to reduce the set reallocations
			set.addAll(firstList);
			listToIterate = secondList;
		}else{
			set = new HashSet<String>(secondList.size());
			set.addAll(secondList);
			listToIterate = firstList;
		}
		
		for(String str : listToIterate){
			if(set.contains(str)){
				intersection.add(str);
			}
		}
		return intersection;
		
	}
	
	public Set<String> getCommonStringsBySorting(List<String> firstList, List<String> secondList) {
		
		// no additional space is needed 
		//but the time complexity is max(mlogm, nlogn)
		
		if(firstList == null || firstList.size() == 0 || secondList == null || secondList.size() == 0 ){
			return null;
		}
		Set<String> intersection = new HashSet<String>();
		
		Collections.sort(firstList);
		Collections.sort(secondList);
		int compareValue;
		
		for(int pointerToFirstList=0, pointerToSecondList=0; pointerToFirstList < firstList.size() && pointerToSecondList < secondList.size(); ){
			
			compareValue = firstList.get(pointerToFirstList).compareTo(secondList.get(pointerToSecondList));
			if(compareValue == 0 ){
				intersection.add(firstList.get(pointerToFirstList));
				pointerToFirstList++;
				pointerToSecondList++;
			}else if(compareValue < 0){
				pointerToFirstList++;
			}else{
				pointerToSecondList++;
			}
		}
		
		return intersection;
		
	}
	
}