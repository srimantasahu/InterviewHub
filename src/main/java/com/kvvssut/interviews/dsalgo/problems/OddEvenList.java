package com.kvvssut.interviews.dsalgo.problems;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        System.out.println(new OddEvenList().oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode startOddNode = head;
            if (head.next != null) {
                head = head.next;
                ListNode startEvenNode = head;
                ListNode oddNode = startOddNode;
                ListNode evenNode = startEvenNode;
                boolean odd = true;

                while (head.next != null) {
                    head = head.next;
                    if (odd) {
                        oddNode.next = head;
                        oddNode = head;
                    } else {
                        evenNode.next = head;
                        evenNode = head;
                    }
                    odd = !odd;
                }

                if (odd) {
                    oddNode.next = null;
                } else {
                    evenNode.next = null;
                }
                oddNode.next = startEvenNode;
            }
            return startOddNode;
        }
        return null;
    }
}