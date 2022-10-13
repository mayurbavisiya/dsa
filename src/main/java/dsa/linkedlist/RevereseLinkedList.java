package dsa.linkedlist;

public class RevereseLinkedList {

	static class Node {

		int data;
		Node next;

		public Node(int d) {
			this.data = d;
			next = null;
		}
	}

	static void printList(Node ls) {
		if (ls == null)
			return;
		while (ls != null) {
			System.out.print(ls.data + " ");
			ls = ls.next;
		}
	}

	public static void main(String[] args) {
		Node ls = new Node(1);
		ls.next = new Node(2);
		ls.next.next = new Node(3);
		ls.next.next.next = new Node(4);
		ls.next.next.next.next = new Node(5);
		printList(ls);
		reverseList(ls);
	}

	private static void reverseList(Node head) {
		Node prev = null;
		Node next = null;
		Node curr = head;
		prev = reverse(prev, curr, next);
		System.out.println();
		printList(prev);
	}

	private static Node reverse(Node prev, Node curr, Node next) {
		if (curr == null) {
			return prev;
		}
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		return reverse(prev, curr, next);
	}

	// Iterative
	private static void reverseListIterative(Node head) {

		Node prev = null;
		Node next = null;
		Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		System.out.println();
		printList(prev);
	}
}
