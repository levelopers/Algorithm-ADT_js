package com.jiuzhang;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        testQuickSort();


    }



    public static void testArraySort() {
        int[] array = new int[] {3, 1, 6, 4, 7};
        SortAlgos.quickSort(array);
        printBool(array[0] == 1);
        printBool(array[1] == 3);
        printBool(array[2] == 4);
        printBool(array[3] == 6);
        printBool(array[4] == 7);
    }

    public static void testQuickSort() {
        int len = 100;
        int[] array = new int[len];
        Random random = new Random();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < len; ++i) {
            int number = random.nextInt();
            array[i] = number;

            if(freq.containsKey(number)) {
                freq.put(number, freq.get(number) + 1);
            } else {
                freq.put(number, 1);
            }
        }

        SortAlgos.quickSort(array);

        if(array.length != len) {
            System.out.println("Failed");
            return;
        }

        Map<Integer, Integer> newFreq = new HashMap<>();

        for(int i = 0; i < len; ++i) {

            int number = array[i];

            if(newFreq.containsKey(number)) {
                newFreq.put(number, freq.get(number) + 1);
            } else {
                newFreq.put(number, 1);
            }
        }

        if(!freq.equals(newFreq)) {
            System.out.println("Failed");
            return;
        }

        for(int i = 1; i < len; ++i) {
            if(array[i] < array[i-1]) {
                System.out.println("Failed");
                return;
            }
        }

        System.out.println("Succeed");
    }

    private static void printBool(boolean val) {
        System.out.println(val);
    }

}
