package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.ListNode;

/*
    Given the head of a singly linked list, return true if it is a palindrome.
*/

public class LinkedList_Palindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

}
