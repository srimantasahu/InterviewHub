package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

public class KthElementFromEndInLinkedList {

    public static void main(String[] args) {
        LinkedList head = createNode("Start");
        addNode(head, "First");
        addNode(head, "Second");
        addNode(head, "Third");
        addNode(head, "Final");

        LinkedList secondElementFromLast = getKthNodeFormLast(head, 4);
        System.out.println(secondElementFromLast.name);
    }

    private static LinkedList getKthNodeFormLast(LinkedList head, int k) {
        LinkedList kthNodeFromLast = head, current = head;

        for (int i = 0; i < k; i++) {
            if (current == null) {
                throw new IllegalArgumentException("Entered index is out of bound!");
            }
            current = current.getNext();
        }

        while (current != null) {
            current = current.getNext();
            kthNodeFromLast = kthNodeFromLast.getNext();
        }

        return kthNodeFromLast;
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

    static class LinkedList {
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

}
