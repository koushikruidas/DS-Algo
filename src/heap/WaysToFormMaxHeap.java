package com.koushik.heap;

import java.util.HashMap;

public class WaysToFormMaxHeap {
	    static HashMap<String, Integer> memo = new HashMap<String, Integer>();
	    static HashMap<Integer, Integer> memo1 = new HashMap<Integer, Integer>();
	    static int m = 1000000007;
	    public int solve(int A) {
	        if(A <= 1) {
	        	memo1.put(A, 1);
	        	return 1;
	        }
	        if(memo1.containsKey(A)) 
	        	return memo1.get(A);
	        int height = (int) (Math.log(A)/Math.log(2));
	        int power = (int) (Math.pow(2,height - 1));
	        int no_of_nodes_at_last_level = (int) (Math.pow(2,height) - 1);
	        int L = (power - 1) + Math.min(power, (A - no_of_nodes_at_last_level)); 
	        int choice = choose(A-1,L);
	        int leftSide = solve(L);
	        int rightSide = solve(A - 1 - L);
	        int res = mul(choice, mul(leftSide,rightSide));
	        memo1.put(A, res);
	        return res;
	    }

	    public static int choose(int n, int k){
	        String key = n+"+"+k;
	        if( k > n ) return 0;
	        if(memo.containsKey(key)) return memo.get(key);
	        if(n == k || k == 0) {
	            memo.put(key,1);
	            return 1;
	        }
	        int res = add(choose(n-1,k-1),choose(n-1,k));
	        memo.put(key,res);
	        return res;
	    }
	    
	    public static int mod(int x) {
	    	return ((x % m + m)%m);
	    }
	    
	    public static int add(int a, int b) {
	    	return mod(mod(a) + mod(b));
	    }
	    
	    public static int mul(int a, int b) {
	    	return mod(mod(a)*mod(b));
	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
	    	WaysToFormMaxHeap var = new WaysToFormMaxHeap();
	    	System.out.println(var.solve(20));

		}
}
