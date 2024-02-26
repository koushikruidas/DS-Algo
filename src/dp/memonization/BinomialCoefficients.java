package com.koushik.heap;

import java.util.HashMap;

public class BinomialCoefficients {
	public static int solve(int n, int k, HashMap<String, Integer> memo) {
		String key = n +"+"+k;
//		System.out.println(key);
		
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		if(k > n) {
			return 0;
		}
		if( n == k || k == 0) {
			memo.put(key, 1);
			return 1;
		}
		int res = solve(n-1,k-1,memo) + solve(n-1, k, memo);
		memo.put(key, res);
		return res;
	}
	public static void main(String[] args) {
		int res = solve(5,3, new HashMap<String, Integer>());
		System.out.println(res);
		System.out.println(Math.log(4));
	}
}
