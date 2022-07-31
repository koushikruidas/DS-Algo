package com.koushik.heap;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheImpl {
	private int capacity;
	private int size;
	private Node1 cache = new Node1(0);
	private HashMap<Integer, Node1> map; 
	LRUCacheImpl(int capacity){
		this.capacity = capacity;
		size = 0;
		map = new HashMap<Integer,Node1>(capacity);
	}
	
	public boolean put(int x) {
		if(size == capacity ) {
			map.remove(cache.prev.data);
			cache.remove(cache, cache.prev);
			size--;
			cache.addFirst(cache, x);
			map.remove(x);
			map.put(x, cache.next);
			size++;
		}
		else if(map.containsKey(x)) {
			Node1 tmp = map.get(x);
			cache.remove(cache, tmp);
			size--;
			cache.addFirst(cache, x);
			size++;
			map.put(x, cache.next);
		}
		else {
			cache.addFirst(cache, x);
			size++;
			map.put(x, cache.next);
		}
		return true;
	}
	
	public Node1 get(int x) {
		if(map.containsKey(x)) {
			cache.remove(cache, map.get(x));
			cache.addFirst(cache, x);
			return map.get(x);
		}
		return null;
	}
	
	public static void main(String[] args) {
		LRUCacheImpl var = new LRUCacheImpl(3);
		var.put(1);
		var.put(2);
		System.out.println(var.get(1).data);
		var.put(3);
		System.out.println(var.get(2).data);
		var.put(4);
		System.out.println(var.get(1));
		System.out.println(var.get(3).data);
		System.out.println(var.get(4).data);
	}
}

class Node1 {
	int data;
	Node1 next;
	Node1 prev;
	Node1(){}
	Node1(int data){
		this.data = data;
		next = this;
		prev = this;
	}
	
	public void addFirst(Node1 head, int data) {
		Node1 temp = head.next;
		head.next = new Node1(data);
		head.next.next = temp;
		temp.prev = head.next;
	}
	
	public void remove(Node1 head, Node1 removeableNode) {
		// if first node to be removed
		if(removeableNode.prev == head) {
			head.next = removeableNode.next;
			removeableNode.next.prev = head;
		}
		
		// last node to be removed
		else if(removeableNode.next == head) {
			removeableNode.prev.next = head;
			head.prev = removeableNode.prev;
		}
		
		// middle node to be removed
		else {
			removeableNode.prev.next = removeableNode.next;
			removeableNode.next.prev = removeableNode.prev;
			removeableNode.next = null;
			removeableNode.prev = null;
		}
	}
}
