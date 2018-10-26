package com.jiuzhang;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Integer> list = new ArrayList<>();
    static List<List> outerList = new ArrayList<>();

    static int sum = 0;

    public static void main(String[]args){
        TreeNode root = buildTree(); //return node1 as root
//        System.out.println(        binaryTreePathSum(root,5));
//        int target = 32;
//
//        helper(list,sum,root,target);
        int x = 10;
        String y = Integer.toString(x);

        System.out.println(y.getClass());


    }

//    public static List<List<Integer>>binaryTreePathSum(TreeNode root, int target) {
//        // write your code here
//
//    }

    //finde path
    private static void helper(List list,int sum,TreeNode root,int target){

        if (root.left==null&&root.right==null){
            System.out.println(list);
            if (sum==target){
                outerList.addAll(list);
//            System.out.println(list);
            }else{
                list.remove(root.val);

            }
            return;

        }




        list.add(root.val);

        helper(list,sum+root.val,root.left,target);

        helper(list,sum+root.val,root.right,target);




    }



    public static class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }

    public static TreeNode buildTree() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node5.left = node7;
        node5.right = node8;

        node6.left = node9;

        return node1;
    }




}
