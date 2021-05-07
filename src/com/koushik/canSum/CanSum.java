package com.koushik.canSum;

public class CanSum {
	
	// write a function that takes in a targetSum and an array of integers as arguments.
	// The function should return true/false depending whether or not it is possible 
	// to generate the targetSum using the numbers from the array.
	
	// You may use the elements of the array as many times as needed.
	
	// You may assume that all imputs are non-negative.
	
	public static boolean canSum(int targetSum, int[] arr) {
		boolean flag = false;
		if(targetSum == 0 ) {
			flag =  true;
			return flag;
		}
		if(targetSum < 0 ) {
			flag = false;
			return flag;
		}
		for(int i = 0; i < arr.length; i++) {
			int remainder = targetSum - arr[i];
			if(canSum(remainder,arr) == true)
				return true;
		}
		return flag;
	}

	public static void main(String[] args) {
		int arr[] = {2,3,5};
		System.out.println(canSum(8, arr));
	}

}
