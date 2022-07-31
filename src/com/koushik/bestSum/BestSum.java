package com.koushik.bestSum;

import java.util.ArrayList;

public class BestSum {

	public static ArrayList<Integer> bestSum(int targetSum, int[] numbers) {
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		ArrayList<Integer> remainderCombinaton;
		ArrayList<Integer> shortestPath = null;
		if (targetSum == 0)
			return (new ArrayList<Integer>()) ;
		if (targetSum < 0)
			return null;
		for (int i = 0; i < numbers.length; i++) {
			int remainder = targetSum - numbers[i];
			remainderCombinaton = bestSum(remainder, numbers);
			if ( remainderCombinaton != null) {
				combinations = remainderCombinaton;
				combinations.add(numbers[i]);
				if (shortestPath == null || shortestPath.size() > combinations.size()) {
					shortestPath = combinations;
				}
			}
		}
		return shortestPath;
	}

	public static void main(String[] args) {
//		int[] arr = { 3, 4, 7 };
//		int[] arr1 = {2,3,5};
//		int[] arr2 = {1,4,5};
//		int[] arr3 = {1,2,5,25};
//		System.out.println(bestSum(7, arr)); // [7]
//		System.out.println(bestSum(8, arr1)); // [3,5]
//		System.out.println(bestSum(8, arr2));
//		System.out.println(bestSum(100, arr3)); // [25,25,25,25]
		System.out.println("strawberries".substring(2, 5));
		System.out.println("apple".compareTo("banana"));
	}

}
