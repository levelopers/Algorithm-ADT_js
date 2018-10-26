package com.jiuzhang;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataStructureExample {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        // CRUD

        // Create
        arrayList.add(10);
        arrayList.add(0, 20);

        // Read
        System.out.println(arrayList.get(0));

        // Update
        arrayList.set(0, 39);

        // Delete
        arrayList.remove(0);


        LinkedList<Integer> linkedList = new LinkedList<>();
        // CRUD

        // Create
        linkedList.add(10);
        linkedList.add(0, 20);

        // Read
        System.out.println(linkedList.get(0));

        // Update
        linkedList.set(0, 39);

        // Delete
        linkedList.remove(0);
    }
}
