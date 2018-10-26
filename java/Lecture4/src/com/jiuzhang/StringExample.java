package com.jiuzhang;

public class StringExample {

    public static void main(String[] args) {
            runStringExample1();
    }

    static void runStringExample1() {
        System.out.println("String example 1");

        System.out.println("12345".substring(0, 4));

        char x = '1';
        String str = "12345"+6;
        String substr = str.substring(0, 4);
        System.out.println(str.charAt(0)==x);

        System.out.println();
    }

    static void runStringExample2() {
        System.out.println("String example 2");

        String str = "1234";
        String str2 = "123" + 4;

        System.out.println(str);
        System.out.println(str2);
        System.out.print(str == str2);

        System.out.print(str.equals(str2));

        System.out.println();
    }

}
