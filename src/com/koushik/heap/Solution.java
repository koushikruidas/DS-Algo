package com.koushik.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int solve(ArrayList<Integer> A, int B) {
        int result = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MyComparator());
        for(int i = 0; i < A.size(); i++){
            maxHeap.add(A.get(i));
        }

        while(!maxHeap.isEmpty() && B > 0){
            int curr = maxHeap.poll();
            result += curr;
            curr--;
            B--;
            maxHeap.add(curr);
        } 
        return result;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(2);
		ar.add(3);
		System.out.println(solve(ar,3));
	}
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        if(a > b) return -1;
        else if(a < b) return 1;
        else return 0;
    }
}
