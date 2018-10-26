package com.jiuzhang;

import java.util.List;

public class SortAlgos {

    public static void selectionSort(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            int minIndex = i;
            for(int j = i+1; j < array.length; ++j) {
                if(array[j] < array[minIndex]) {  //find smallest in UNSORTED array
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);  //put smallest in UNSORTED array into SORTED array
        }
    }

    public static void selectionSortList(List<Integer> list) {
        for(int i = 0; i < list.size(); ++i) {
            int minIndex = i;
            for(int j = i+1; j < list.size(); ++j) {
                if(list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            int t = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, t);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid+1, right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int i = left, j = mid + 1;
        int[] tmp = new int[right - left + 1];
        for (int k = 0; k < right - left + 1; ++k) {
            if(i <= mid && (j > right || array[i] < array[j])) { //array1 = [left,mid] array2 = [mid+1,right]
                tmp[k] = array[i++];  //find smallest in two arrays and put it in tmp array;
            } else {
                tmp[k] = array[j++];
            }
        }

        for (int k = 0; k < right - left + 1; ++k) {
            array[left + k] = tmp[k];
        }
    }

    /*
    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSortHelper(array, tmp, 0, array.length - 1);
    }

    private static void mergeSortHelper(int[] array, int[] tmp, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSortHelper(array, tmp, left, mid);
        mergeSortHelper(array, tmp, mid+1, right);
        merge(array, tmp, left, right);
    }

    private static void merge(int[] array, int[] tmp, int left, int right) {
        int mid = (left + right) / 2;
        int i = left, j = mid + 1;
        for (int k = 0; k < right - left + 1; ++k) {
            if(i <= mid && (j > right || array[i] < array[j])) {
                tmp[k] = array[i++];
            } else {
                tmp[k] = array[j++];
            }
        }

        for (int k = 0; k < right - left + 1; ++k) {
            array[left + k] = tmp[k];
        }
    }

    */

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left, j = right;
        int pivot = array[left + (right - left) / 2];

        while(i <= j) {
            while(i <= j && array[i] < pivot) {
                i++;
            }

            while(i <= j && array[j] > pivot) {
                j--;
            }

            if(i <= j) {
                swap(array, i++, j--);
            }
        }

        quickSortHelper(array, left, j);
        quickSortHelper(array, i, right);
    }

}
