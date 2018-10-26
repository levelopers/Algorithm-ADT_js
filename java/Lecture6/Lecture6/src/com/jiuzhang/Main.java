package com.jiuzhang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    TreeNode root = buildTree();
        TreeNode root1 = buildTree1();

//        preorderTraverse(root);
//        inorderTraverse(root);
//        postorderTraverse(root);

//        System.out.println(x.get(root));

//        TreePathGetter x = new TreePathGetter();
//        int[] array = new int[1000];
//        List<Integer> list = new ArrayList<>();
//        x.printPathsRecur(root, (ArrayList<Integer>) list);

//        System.out.println(        isIdentical(root,root));
//        TreePathSum x = new TreePathSum();
//
//        System.out.println(x.binaryTreePathSum(root1,32));

        Main m1 = new Main();
        System.out.println(m1.zigzagLevelOrder(root));

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        if (root==null){
            return new ArrayList<List<Integer>>(0);
        }

        List<List<Integer>> result = new ArrayList();

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
//        int count_level = 0;
        while(!queue.isEmpty()){
//            count_level++;
            List<Integer> level = new ArrayList();

            int size = queue.size();
            for (int i = 0;i<size ;i++ ){
                TreeNode curr = queue.poll();

                level.add(curr.val);

//                if (count_level%2!=0){
//                    if (curr.right!=null){
//                        queue.offer(curr.right);
//                    }
//                    if (curr.left!=null){
//                        queue.offer(curr.left);
//                    }
//
//                } else{
                    if (curr.left!=null){
                        queue.offer(curr.left);
                    }
                    if (curr.right!=null){
                        queue.offer(curr.right);
                    }

//                }

            }
            result.add(level);
        }
        return result;
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

    public static TreeNode buildTree1() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        TreeNode node10 = new TreeNode(8);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node5.left = node7;
        node5.right = node8;

        node6.left = node9;
        node8.right = node10;

        return node1;
    }




// DFS goes into deepest node and pop off Stack each node in order
    public static void preorderTraverse(TreeNode root) {
        // 8 3 10 1 6 14 7 13

        if(root == null) {
            //pop off the Stack return nothing
            return;
        }

        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    //left --> root --> right
    public static void inorderTraverse(TreeNode root) {
        // 8 3 10 1 6 14 7 13

        if(root == null) {
            return;
        }

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }

    // left --> right --> root
    public static void postorderTraverse(TreeNode root) {
        // 8 3 10 1 6 14 7 13

        if(root == null) {
            return;
        }

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println(root.val);
    }

    public static int getLeafSum(TreeNode root) {
        sum = 0;
        getLeafSumHelper(root);
        return sum;
    }

    public static int sum = 0;

    public static void getLeafSumHelper(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            sum += root.val;
        }

        getLeafSumHelper(root.left);
        getLeafSumHelper(root.right);
    }

    //reverse Tree
    public static void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

    }

    public static boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here

        //null pointer
        if (a==null&&b==null){
            return true ;
        }
        //always false
        if (a==null||b==null){
            return false ;
        }
        if(a.val==b.val){

            //left set of tree is true and right set of tree is true --> return true
            return isIdentical(a.left,b.left)&&isIdentical(a.right,b.right);
        }else{
            return false;
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

class LeafSumGetter {
    private int sum;

    //return sum result
    public int get(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }

    //get sum result
    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            sum += root.val;
        }

        helper(root.left);
        helper(root.right);
    }
}

class TreeHeightGetter {
    private int height;

    public int get(TreeNode root) {
        height = 0;
        helper(root, 1);
        return height;
    }

    private void helper(TreeNode root, int depth) {
        if(root == null) {
            return;
        }

        height = Math.max(height, depth);

        helper(root.left, depth + 1);

        helper(root.right, depth + 1);
    }
}
class TreePathGetter{
    TreeNode root;
    void printPathsRecur(TreeNode node, ArrayList<Integer> path)
    {


        if (node == null)
            return;

        /* append this node to the path array */
        path.add(node.val);
        System.out.println("current: "+path);




        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) {
            printArray(path);


        }
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path);
            printPathsRecur(node.right, path);
        }
    }

    /* Utility function that prints out an array on a line. */
    private void printArray(ArrayList<Integer> ints)
    {
//        System.out.println("length : ");
//
//        int i;
//        for (i = 0; i < ints.size(); i++)
//        {
//            System.out.print(ints.indexOf(i) + " ");
//        }
//        System.out.println("");
        System.out.println(ints);

    }




}

class TreePathSum {
    private ArrayList<List<Integer>> list = new ArrayList();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        int[] array = new int[1000];
        helper(root,array,0,0,target);
        return list;

    }

    private void helper(TreeNode root,int[] array,int len, int sum,int target){
        if (root==null){
            return;
        }
        sum+=root.val;
        array[len]=root.val;

        if (sum==target){
            print(array,len);
        }
        helper(root.left,array,len+1,sum,target);
        helper(root.right,array,len+1,sum,target);

    }

    private void print(int[] array, int len){
        ArrayList<Integer> inner = new ArrayList<>();
        for (int i =0;i<=len;i++){
            inner.add(array[i]);
        }
        list.add(inner);
    }
}


