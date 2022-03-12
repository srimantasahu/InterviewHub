package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.ListNode;

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/

public class LinkedList_RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head2 = head, node1 = head, node2 = head;

        for (int i = 0; i < n; i++) {
            node1 = node1.next;
        }

        if (node1 == null) {
            head2 = head2.next;
        } else {
            while (node1.next != null) {
                node1 = node1.next;
                node2 = node2.next;
            }
            node2.next = node2.next.next;
        }

        return head2;
    }

}

