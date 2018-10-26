package com.jiuzhang;

import java.util.ArrayList;

public class SetArrayListImpl {

    private ArrayList<Integer> data;

    public SetArrayListImpl() {
        data = new ArrayList<>();
    }

    public void add(int val) {
        if(!contains(val)) {
            data.add(val);
        }
    }

    public boolean contains(int val) {
        for(int i = 0; i < data.size(); ++i) {
            if(data.get(i) == val) {
                return true;
            }
        }

        return false;
    }
}
