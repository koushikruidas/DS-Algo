package com.koushik.canSum;

import java.util.HashMap;
import java.util.Map;

public class CanSumWithMemoraization {
	public static boolean canSum(int targetSum, int[] arr, Map<Integer, Boolean>memo) {
		if(memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}
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
			if(canSum(remainder,arr,memo) == true) {
				memo.put(targetSum, true);
				return true;
			}
		}
		memo.put(targetSum, flag);
		return flag;
	}

	public static void main(String[] args) {
//		Map<Integer, Boolean> memo = ;
		int arr[] = {2,3,5};
		int arr1[] = {2,3};
		int arr2[] = {5,3,4,7};
		int arr3[] = {2,4};
		int arr4[] = {7,14};
		System.out.println(canSum(8, arr,new HashMap<Integer, Boolean>()));
		System.out.println(canSum(7,arr1,new HashMap<Integer, Boolean>()));
		System.out.println(canSum(7, arr3, new HashMap<Integer, Boolean>()));
		System.out.println(canSum(300, arr4, new HashMap<Integer, Boolean>()));
		System.out.println(canSum(7, arr4, new HashMap<Integer,Boolean>()));
		System.out.println(canSum(8, arr2, new HashMap<Integer, Boolean>()));
	}

}
