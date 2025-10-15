package com.kvvssut.interviews.codinground.problems;

public class ReverseKGroupLinkedList {

    public static void main(String[] args) {
        ReverseKGroupLinkedList solver = new ReverseKGroupLinkedList();

        System.out.println("Test 1: k=2");
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(arr1);
        printList(solver.reverseKGroup(head1, 2)); // Expected: 2->1->4->3->5

        System.out.println("\nTest 2: k=3");
        int[] arr2 = {1, 2, 3, 4, 5};
        ListNode head2 = createList(arr2);
        printList(solver.reverseKGroup(head2, 3)); // Expected: 3->2->1->4->5

        System.out.println("\nTest 3: k=4");
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head3 = createList(arr3);
        printList(solver.reverseKGroup(head3, 4)); // Expected: 4->3->2->1->8->7->6->5
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointers
        ListNode prevGroupTail = dummy;  // the node before the current group
        ListNode curr = head;            // starting node for each group

        while (true) {
            // Step 1: Find the kth node from curr
            ListNode kth = getKthNode(prevGroupTail, k);
            if (kth == null) break; // Not enough nodes left → stop

            ListNode nextGroupHead = kth.next; // store start of next group

            // Step 2: Reverse the current group
            ListNode prev = nextGroupHead;
            curr = prevGroupTail.next; // first node in this group

            while (curr != nextGroupHead) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Step 3: Reconnect reversed group
            ListNode groupHead = prevGroupTail.next; // old head (now tail)
            prevGroupTail.next = kth;                // new head of this group
            prevGroupTail = groupHead;               // move prevGroupTail forward
        }

        return dummy.next;
    }

    // Helper: returns the kth node from 'curr'
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // `Utility to create linked list from array
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility to print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}