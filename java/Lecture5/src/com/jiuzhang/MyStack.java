package com.jiuzhang;

import java.util.NoSuchElementException;

public class MyStack {

    private ListNode head;

    public void push(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    public int pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        int ret = head.val;
        head = head.next;
        return ret;
    }

    public int peeK() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }
}
