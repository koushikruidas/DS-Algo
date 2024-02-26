package com.koushik.test;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size() - 1;
        System.out.println(len);
        buildHeap(A);
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i = 0; i < B; i++)
            ar.add(delete(A));
        return ar;
    }

    public static void buildHeap(ArrayList<Integer> A){
        int mid = (A.size() - 1) / 2;
        for(int i = mid; i >= 0; i--){
            maxHeapify(A, i);
        }
    }

    public static void maxHeapify(ArrayList<Integer> A, int i){
        int left = 2*i;
        int right = 2*i + 1;
        int largest = 0;
        if(left < A.size() && A.get(left) > A.get(i))
            largest = left;
        else 
            largest = i;
        if(right < A.size() && A.get(right) > A.get(largest))
            largest = right;
        if(largest != i){
            swap(A, i, largest);
            maxHeapify(A,largest);
        }
    }

    public static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public static int delete(ArrayList<Integer> A){
        int temp = A.get(0);
        int len = A.size();
        int n = A.get(len-1);
        A.set(0,n);
        A.remove(len-1);
        maxHeapify(A, 0);
        return temp;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(715);
		ar.add(479);
//		ar.add(359);
//		ar.add(963);
//		ar.add(465);
//		ar.add(706);
//		ar.add(146);
//		ar.add(282);
//		ar.add(828);
//		ar.add(962);
		solve(ar, 2);
	}
}

