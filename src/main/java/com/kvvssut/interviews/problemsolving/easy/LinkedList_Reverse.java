package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.ListNode;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

public class LinkedList_Reverse {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode reversed = new ListNode(head.val);

        return reverseList(head.next, reversed);
    }

    private ListNode reverseList(ListNode node, ListNode reversed) {
        if (node != null) {
            ListNode reversedNode = new ListNode(node.val);
            reversedNode.next = reversed;
            reversed = reversedNode;

            return reverseList(node.next, reversed);
        }

        return reversed;
    }

}