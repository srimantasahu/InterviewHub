package com.kvvssut.interviews.java.arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayPractice {
	
	private void varargs(int... args) {
		for(int i : args){			// dynamic autoboxing to Integer type for iteration with for:each loop 
			System.out.println(i);
		}
		
		StringBuilder sbuild = new StringBuilder("nihar");
		sbuild.append("Ranjan");
		
		StringBuffer sbuf = new StringBuffer("nihar");
		sbuf.append("Ranjan");
		
		int [] arr = new int [] {1,2,3,};	// optional comma at the end, no additional slot is created 
	}
	
	
	private void arraysEquals() {
		int [] arr1 = {1,2,5,3};
		int [] arr2 = {1,2,5,3};
		
		System.out.println(Arrays.equals(arr1, arr2));	// true  <-  matches corresponding pairs of both the arrays
		
		System.out.println(Arrays.toString(arr1));		// prints all array elements
	}
	
	
	private void arraysAsList() {
		int [] arr = new int[5];
		arr[0] = 5;
		arr[1] = 9;
		arr[4] = 14;
		
		List<int []> list = Arrays.asList(arr);
		
		for (int i[] : list) {
			for (int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		char [] value = {'l','e','a','r','n'};
		// In the Java programming language, arrays are objects, are dynamically created, 
		// and may be assigned to variables of type Object. All methods of class Object may be invoked on an array. 
		Object object = value;
		System.out.println(value.toString());	// [C@7c1c8c58	/	[I@36422510
		char [] frmObject = (char [])object;
		System.out.println(String.valueOf(value) + " -equals- " + String.valueOf(frmObject));	// learn -equals- learn
		

		//new ArrayPractice().arraysAsList();
		
//		for(int i : list){
//			
//		}
//		System.out.println(Collections.(list));
	}

}
