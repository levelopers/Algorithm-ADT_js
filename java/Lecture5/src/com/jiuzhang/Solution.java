package com.jiuzhang;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isPrime(int y){
        for (int i = 2;i<y;i++){
            if (y%i==0){
                return false;
            }

        }
        return true;
    }
    public static void what(){

    }
    public static List<Integer> primeFactorization(int num){
        int result = num;
        List<Integer> list = new ArrayList<>();

        for (int x = 2;x<=result;x++){
            if (isPrime(x)&&result%x==0){
                result = result/x;
                System.out.println("result : "+result);
                list.add(x);
                System.out.println("i : "+x);

                x=1;
            }
        }
        return list;
    }
    public static void main(String []args){

        System.out.println(primeFactorization(660));

    }
}
