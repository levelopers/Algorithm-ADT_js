package com.jiuzhang;

public class OsStackExample {

    public static void main(String[] args) {
        int num = 10;
        foo();
    }

    public static void foo() {
        String name = "abc";
        bar();
    }

    public static void bar() {
        baz();

        int[] arr = new int[] {1, 2, 3};
        for(int elem : arr) {
            System.out.println(elem);
        }
    }

    public static void baz() {
        ListNode listNode = new ListNode(0);
    }
}
