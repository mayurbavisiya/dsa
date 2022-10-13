package com.linkedlist;

public class Program139 {

	public static void main(String[] args) {

	}

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node reverse(Node head) {
		Node cur = head;
		Node prev = null;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			
		}
		head  = prev;
		return head;
	}
}
