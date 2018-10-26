package com.jiuzhang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OOExample {

    public static void main(String[] args) {
//        Student a = new Student();
//        Student b = new Student();
        long a = 853119666 - 403716510;
        System.out.println(a);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of students:");
        int n = scanner.nextInt();

        Student[] students = new Student[n];
        for(int i = 0; i < n; ++i) {
            System.out.println("Please input the name and score of student " + (i + 1) + " ,separated by space:");
            students[i] = new Student();
            students[i].name = scanner.next();
            students[i].score = scanner.nextInt();
        }

        System.out.println("\nInput: ");
        for(Student student : students) {
            student.print();
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });

        System.out.println("\nSorted: ");

        for(Student student : students) {
            student.print();
        }
    }
}

class Student {
    String name;
    int score;

    void print() {
        System.out.println(name + ": " + score);
        System.out.println(this);
    }
}
