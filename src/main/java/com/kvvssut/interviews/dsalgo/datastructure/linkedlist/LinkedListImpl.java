package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

final class LinkedList {
	public String name;
	public LinkedList next;

	public LinkedList(String name, LinkedList next) {
		this.name = name;
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

}

public class LinkedListImpl {

	public static void main(String[] args) {
		LinkedList head = createNode("Start");
		addNode(head, "First");
		addNode(head, "Second");
		addNode(head, "Third");
		addNode(head, "Final");
		printList(head);
	}

	public static LinkedList createNode(String name) {
		return new LinkedList(name, null);
	}

	public static void addNode(LinkedList head, String name) {
		LinkedList newNode = createNode(name);
		LinkedList currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
	}

	public static void printList(LinkedList head) {
		LinkedList currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getName());
			currentNode = currentNode.getNext();
		}
	}

}
