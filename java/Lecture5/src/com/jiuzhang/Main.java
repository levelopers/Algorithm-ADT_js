package com.jiuzhang;
import java.util.Stack;
public class Main {
    Stack<Integer> inbox = new Stack<Integer>();
    public Main(){


    }
    public void push(int element) {
        // write your code here
        inbox.push(element);

    }
    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        m.push(1);
        System.out.println(m.inbox.pop());
    }
}
