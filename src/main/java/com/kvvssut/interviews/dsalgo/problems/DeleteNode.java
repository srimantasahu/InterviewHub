package com.kvvssut.interviews.dsalgo.problems;

class DeleteNode {

    private ListNode head;

    public static void main(String[] args) {
        DeleteNode obj = new DeleteNode();
        obj.head = new ListNode(4);
        obj.head.next = new ListNode(5);
        obj.head.next.next = new ListNode(1);
        obj.head.next.next.next = new ListNode(9);

        obj.deleteNode(obj.head.next.next);

        while (obj.head != null) {
            System.out.print(obj.head.val + " ");
            obj.head = obj.head.next;
        }
    }

    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}