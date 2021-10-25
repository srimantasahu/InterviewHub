package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

public class ReverseALinkedList {

	static class LinkedList {
		private int number;
		private LinkedList next;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public LinkedList getNext() {
			return next;
		}

		public void setNext(LinkedList next) {
			this.next = next;
		}

	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.setNumber(10);
		LinkedList next1 = new LinkedList();
		next1.setNumber(20);
		head.setNext(next1);
		LinkedList next2 = new LinkedList();
		next2.setNumber(30);
		next1.setNext(next2);
		LinkedList next3 = new LinkedList();
		next3.setNumber(40);
		next2.setNext(next3);
		LinkedList next4 = new LinkedList();
		next4.setNumber(50);
		next3.setNext(next4);
		next4.setNext(null);

		printLinkedList(head);

		System.out.println("\nReversing the linked list - \n");
		LinkedList lastNode = reverseLinkedList(head);

		System.out.println("\nPrinting the reversed linked list - \n");
		printLinkedList(lastNode);

	}

	public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList prev = null, current = head, next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		return prev;
	}

	public static void printLinkedList(LinkedList head) {
		LinkedList node = head;
		while (node != null) {
			System.out.println(node.getNumber() + "," + node);
			node = node.getNext();
		}
	}

}
