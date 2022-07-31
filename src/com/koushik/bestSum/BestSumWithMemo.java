package com.koushik.bestSum;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSumWithMemo {

	public static ArrayList<Integer> bestSum(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo) {
		if(memo.containsKey(targetSum))
			return memo.get(targetSum);
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		ArrayList<Integer> remainderCombinaton;
		ArrayList<Integer> shortestPath = null;
		if (targetSum == 0)
			return (new ArrayList<Integer>()) ;
		if (targetSum < 0)
			return null;
		for (int i = 0; i < numbers.length; i++) {
			int remainder = targetSum - numbers[i];
			remainderCombinaton = bestSum(remainder, numbers,memo);
			if ( remainderCombinaton != null) {
				combinations = remainderCombinaton;
				combinations.add(numbers[i]);
				if (shortestPath == null || shortestPath.size() > combinations.size()) {
					shortestPath = combinations;
				}
			}
		}
		memo.put(targetSum, shortestPath);
		return shortestPath;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 7 };
		int[] arr1 = {2,3,5};
		int[] arr2 = {1,4}; // 5
		int[] arr3 = {1,2,5,25};
		System.out.println(bestSum(7, arr, new HashMap<Integer,ArrayList<Integer>>() )); // [7]
		System.out.println(bestSum(8, arr1, new HashMap<Integer,ArrayList<Integer>>() )); // [3,5]
		System.out.println(bestSum(2, arr2, new HashMap<Integer,ArrayList<Integer>>() )); // [4,4]
		System.out.println(bestSum(100, arr3, new HashMap<Integer,ArrayList<Integer>>() )); // [25,25,25,25]
	}

}
