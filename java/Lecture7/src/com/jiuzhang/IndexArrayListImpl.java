package com.jiuzhang;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class IndexArrayListImpl {

    private ArrayList<Pair> keyValuePairs; //array of objects

    public IndexArrayListImpl() {
        this.keyValuePairs = new ArrayList<>();
    }

    public void put(String key, int val) {
        for(int i = 0; i < keyValuePairs.size(); ++i) {
            if(keyValuePairs.get(i).key.equals(key)) { //replace value with duplicate key
                keyValuePairs.get(i).val = val;
                return;
            }
        }
        keyValuePairs.add(new Pair(key, val));
    }

    public int get(String key) {
        for(int i = 0; i < keyValuePairs.size(); ++i) {
            if(keyValuePairs.get(i).key.equals(key)) { //pair is an object
                return keyValuePairs.get(i).val;
            }
        }

        throw new NoSuchElementException();
    }
}

class Pair {
    public String key;
    public int val;

    public Pair(String key, int val) {
        this.key = key;
        this.val = val;
    }
}
