package com.jiuzhang;

public class LinkedListExample {

    public static void main(String[] args) {
        // runLinkedListExample();


        insertNode(runLinkedListExample(),5);
    }

    public static ListNode runLinkedListExample() {
        System.out.println("LinkedList example");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode cur = node1;

        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        return node1;
    }

    public static ListNode insertNode(ListNode head, int val) {
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        System.out.println(head.next+"" +head.val);

        // find the last element <= val
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        node.next = head.next;
        head.next = node;

        return dummy.next;
    }

}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
