package com.jiuzhang;

public class BST {

    private TreeNode root;

    public void add(int val) {
        root = addHelper(root, val);
    }

    private TreeNode addHelper(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            root.left = addHelper(root.left, val);
        } else {
            root.right = addHelper(root.right, val);
        }

        return root;
    }

    public boolean contains(int val) {
        return containsHelper(root, val);
    }

    private boolean containsHelper(TreeNode root, int val) {
        if(root == null) {
            return false;
        }

        if(val == root.val) {
            return true;
        } else if(val < root.val) {
            return containsHelper(root.left, val);
        } else {
            return containsHelper(root.right, val);
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}