package com.koushik.Grid;

import java.util.HashMap;

public class GridTraveler {

	protected int numOfPaths(int row, int column, HashMap<String, Integer> memo) {
		String key = row+" , "+column;
		if(memo.containsKey(key))
			return memo.get(key);
		if(row == 1 && column == 1)
			return 1;
		if(row <= 0 || column <= 0)
			return 0;
		int value = numOfPaths(row - 1, column,memo) + numOfPaths(row, column - 1,memo);
		memo.put(key, value);
		return value;
	}
	
	public static void main(String[] args) {
		GridTraveler grd = new GridTraveler();
		HashMap<String, Integer> memo = new HashMap<String, Integer>();
		System.out.println(grd.numOfPaths(2, 2, memo)); 
		System.out.println(grd.numOfPaths(1, 1, memo));
		System.out.println(grd.numOfPaths(2, 3, memo));
		System.out.println(grd.numOfPaths(4,4, memo));
		System.out.println(grd.numOfPaths(3, 3, memo));
		System.out.println(grd.numOfPaths(9, 9, memo));
	}

}
