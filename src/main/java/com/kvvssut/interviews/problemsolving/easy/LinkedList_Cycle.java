package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.ListNode;

/*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
*/

public class LinkedList_Cycle {

    public boolean hasCycle(ListNode head) {
        ListNode head2 = head;

        while (head2 != null) {
            if (head2.next == null) {
                return false;
            }

            head = head.next;
            head2 = head2.next.next;

            if (head == head2) {
                return true;
            }
        }

        return false;
    }

}
