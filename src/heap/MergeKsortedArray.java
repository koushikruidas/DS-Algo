package com.koushik.heap;

import java.util.PriorityQueue;

class Node {
	int data;
	Node next;
	Node(){}
	Node(int data){
		this.data = data;
		next = null;
	}
}

public class MergeKsortedArray {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		// Total number of lists
		int k = 3;
		// max number of elements present in each lists
		int n = 4;
		// array for holding head nodes of each lists
		Node[] ar = new Node[k];
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		ar[0] = head1;
		Node head2 = new Node(5);
		head2.next = new Node(6);
		head2.next.next = new Node(7);
		ar[1] =  head2;
		Node head3 = new Node(8);
		head3.next = new Node(9);
		ar[2] = head3;
		Node head = mergeKList(ar,ar.length);
	}
	
	public static Node mergeKList(Node[] arr, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		
		for(int i = 0; i < k; i++) {
			if(arr[i] != null) {
				minHeap.add(arr[i]);
			}
		}
		Node head = new Node(0);
		Node last = head;
		if(minHeap.isEmpty()) return null;
		while(!minHeap.isEmpty()) {
			Node curr = minHeap.poll();
			last.next = curr;
			last = last.next;
			if(curr.next != null) {
				minHeap.add(curr.next);
			}
		}
		return head.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
