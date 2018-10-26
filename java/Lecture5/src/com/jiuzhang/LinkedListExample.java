package com.jiuzhang;

import java.util.Stack;

public class LinkedListExample {

    public static void main(String[] args) {
            String s = "[()]";
        System.out.println(isValidParentheses(s));

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

//        traverseLinkedList(removeNthFromEnd(node1,1));
        /*dummy : 01
pre : 01
head : 1
dummy : 01
pre : 01
head :
dummy : 01
pre : 01
head :
dummy : 01
pre : 0
head :
1
*/




    }

    public static boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {


            if (n <= 0) {
                return null;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode preDelete = dummy;
//            ListNode preDelete = new ListNode(0);
//            preDelete.next = head;
       // System.out.println("");


        System.out.print("dummy : ");
            traverseLinkedList(dummy);
        System.out.print("pre : ");
            traverseLinkedList(preDelete);
        System.out.print("head : ");
            traverseLinkedList(head);


            for (int i = 0; i < n; i++) {
                if (head == null) {
                    return null;
                }
                head = head.next;
            }

        System.out.print("dummy : ");
        traverseLinkedList(dummy);
        System.out.print("pre : ");
        traverseLinkedList(preDelete);
        System.out.print("head : ");
        traverseLinkedList(head);

            while (head != null) {
                head = head.next;
                preDelete = preDelete.next;
            }

        System.out.print("dummy : ");
        traverseLinkedList(dummy);
        System.out.print("pre : ");
        traverseLinkedList(preDelete);
        System.out.print("head : ");
        traverseLinkedList(head);

            preDelete.next = preDelete.next.next;

        System.out.print("dummy : ");
        traverseLinkedList(dummy);
        System.out.print("pre : ");
        traverseLinkedList(preDelete);
        System.out.print("head : ");
        traverseLinkedList(head);
            return dummy.next;
    }

    public static ListNode mySolution(ListNode head, int n) {
        // write your code here
        ListNode x = new ListNode(0);
        ListNode y = new ListNode(0);
        y.next = head;
        x.next = head;

        System.out.print("x : ");
        traverseLinkedList(x);
        System.out.print("y : ");
        traverseLinkedList(y);
        System.out.print("head : ");
        traverseLinkedList(head);

        for (int i = 0;i<n ;i++ ){
            head = head.next;

        }

        System.out.print("x : ");
        traverseLinkedList(x);
        System.out.print("y : ");
        traverseLinkedList(y);
        System.out.print("head : ");
        traverseLinkedList(head);

        while(head.next!=null){
            x = x.next;
            head = head.next;
        }

        System.out.print("x : ");
        traverseLinkedList(x);
        System.out.print("y : ");
        traverseLinkedList(y);
        System.out.print("head : ");
        traverseLinkedList(head);

        if (n>1){
            x.next = head;
        } else {
            return x.next;

        }

        System.out.print("x : ");
        traverseLinkedList(x);
        System.out.print("y : ");
        traverseLinkedList(y);
        System.out.print("head : ");
        traverseLinkedList(head);

        return y.next;
    }


    public static void runLinkedListExample() {
        System.out.println("LinkedList example");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode cur = node1;

        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void runLinkedListQuiz1() {
        System.out.println("LinkedList quiz 1");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2 = node3;

        ListNode cur = node1;

        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void runLinkedListQuiz2() {
        System.out.println("LinkedList quiz 2");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1 = node2;

        ListNode cur = node1;

        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void runLinkedListQuiz3() {
        System.out.println("LinkedList quiz 3");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        traverseLinkedList(node1);
        traverseLinkedList(node1);
    }

    public static void runLinkedListQuiz4() {
        System.out.println("LinkedList quiz 3");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.next = node3;

        traverseLinkedList(node1);
    }

    public static void traverseLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void testMyLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 1);
        myLinkedList.add(0, 2);
        myLinkedList.add(0, 3);
        myLinkedList.add(0, 4);
        myLinkedList.add(2, 10);

        System.out.println(myLinkedList.get(0) == 4);
        System.out.println(myLinkedList.get(1) == 3);
        System.out.println(myLinkedList.get(2) == 10);
        System.out.println(myLinkedList.get(3) == 2);
        System.out.println(myLinkedList.get(4) == 1);
    }

}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
