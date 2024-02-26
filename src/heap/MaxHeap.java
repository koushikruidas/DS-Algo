package com.koushik.heap;

public class MaxHeap {
	public static void main(String[] args) {
		int ar[] = {16,4,10,14,7,9,3,2,8,1};
		int len = ar.length;
		for(int i = len/2; i > 0 ; i--) {
			maxHeapify(ar,i);
		}
		for(int i = 0; i < len; i++)
			System.out.print(ar[i]+" ");
	}
	
	public static void maxHeapify(int[] ar, int i) {
		int left = 2*i - 1;
		int right = 2*i;
		int len = ar.length - 1;
		int largest = 0;
		if(left <= len && ar[i] < ar[left])
			largest = left;
		else
			largest = i;
		if(right <= len && ar[largest] < ar[right])
			largest = right;
		if(largest != i) {
			swap(ar, i, largest);
			maxHeapify(ar, largest);
		}
	}
	
	public static void swap(int[] ar, int i, int j) {
		int a = ar[i];
		ar[i] =  ar[j];
		ar[j] = a;
	}

}
