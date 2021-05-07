package com.koushik.howSum;

import java.util.ArrayList;

public class HowSum {
	// Write a function `howSum(targetSum, numbers)` that takes in targetSum and an array of numbers
	// as an input arguments.
	
	// The function should return an array containing any combination of elements that add up to exactly targetSum.
	// If there is no combination that adds up to targetSum, then return null.
	
	// If there are multiple combination possible, you may return any single one.
	
	public static ArrayList<Integer> howSum(int targetSum, int[] numbers, ArrayList<Integer> list) {
		if(targetSum == 0) {
//			list.add(null)
			return list;
		}
		if(targetSum < 0) {
			return null;
		}
		for(int i = 0; i < numbers.length; i++) {
			int remainder = targetSum - numbers[i];
			if(howSum(remainder, numbers, list) != null) {
				list.add(numbers[i]);
				return list;
			}
		}
//		System.out.println("Printing the list: "+list);
		return null;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,5};
		int arr1[] = {2,3};
		int arr2[] = {5,3,4,7};
		int arr3[] = {2,4};
		int arr4[] = {7,14};
		System.out.println(howSum(0, arr,new ArrayList<Integer>()));
		System.out.println(howSum(7,arr1,new ArrayList<Integer>()));
		System.out.println(howSum(7, arr3, new ArrayList<Integer>()));
		System.out.println(howSum(300, arr4, new ArrayList<Integer>()));
		System.out.println(howSum(7, arr4, new ArrayList<Integer>()));
		System.out.println(howSum(8, arr2, new ArrayList<Integer>()));
	}
}
