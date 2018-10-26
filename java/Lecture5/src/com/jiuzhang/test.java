package com.jiuzhang;

public class test {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

        public  static ListNode removeNthFromEnd(ListNode head, int n) {
            if (n <= 0) {
                return null;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode preDelete = dummy;
            for (int i = 0; i < n; i++) {
                if (head == null) {
                    return null;
                }
                head = head.next;
            }
            while (head != null) {
                head = head.next;
                preDelete = preDelete.next;
            }
            preDelete.next = preDelete.next.next;
            return dummy.next;
        }


    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

    }
}
