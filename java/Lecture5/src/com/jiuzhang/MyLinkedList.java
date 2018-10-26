package com.jiuzhang;

public class MyLinkedList {
    private ListNode head;



    // create
    public void add(int location, int value) {
        if (location > 0) {
            ListNode prev = head;
            for (int i = 0; i < location - 1; ++i) {

                if (prev == null) {
                    throw new ArrayIndexOutOfBoundsException("Invalid location " + location);
                }

                prev = prev.next;
            }

            ListNode next = prev.next;
            ListNode newNode = new ListNode(value);
            prev.next = newNode;
            newNode.next = next;

        } else if (location == 0) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            head = newHead;
        }
    }

    // read
    public int get(int location) {

        ListNode cur = head;

        for (int i = 0; i < location; ++i) {

            if (cur == null) {
                throw new ArrayIndexOutOfBoundsException("Invalid location " + location);
            }

            cur = cur.next;
        }

        return cur.val;
    }

    // update
    public void set(int location, int newValue) {

    }

    // delete
    public int remove(int location) {
        return 0;
    }

}
