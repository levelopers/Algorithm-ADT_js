package com.jiuzhang;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        testSetArrayListImpl();
    }

    public static void testSetArrayListImpl() {
        SetArrayListImpl set = new SetArrayListImpl();

        for(int i = 0; i < 1000; ++i) {
            set.add(i);
        }

        boolean success = true;

        for(int i = 0; i < 1000; ++i) {
            if(!set.contains(i)) {
                success = false;
                break;
            }
        }

        System.out.println(success);
    }

    public static void testSetBSTImpl() {
        SetBSTImpl set = new SetBSTImpl();

        for(int i = 0; i < 1000; ++i) {
            set.add(i);
        }

        boolean success = true;

        for(int i = 0; i < 1000; ++i) {
            if(!set.contains(i)) {
                success = false;
                break;
            }
        }

        System.out.println(success);
    }

    public static void runHashSetExample() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.contains(1) == true);
        System.out.println(set.contains(2) == true);
        System.out.println(set.contains(3) == true);
        System.out.println(set.contains(4) == true);
        System.out.println(set.contains(5) == false);
        System.out.println(set.contains(6) == false);
        System.out.println(set.contains(7) == false);

    }

    public static void testIndexArrayListImpl() {
        IndexArrayListImpl index = new IndexArrayListImpl();
        index.put("Jack", 10);
        index.put("Tom", 20);
        index.put("Alen", 30);

        System.out.println(index.get("Jack") == 1);

        index.put("Jack", 1);
        System.out.println(index.get("Jack") == 1);
    }

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
