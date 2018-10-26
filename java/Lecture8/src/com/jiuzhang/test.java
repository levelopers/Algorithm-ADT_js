package com.jiuzhang;


import java.lang.reflect.Array;
import java.util.*;

public class test {

    public static void main(String[] args){
        int [] array = {3,2,1,4,5};
        int [] sorted_array = {2,3,4,5,6,7,8};
//        test t = new test();
//        t.sortIntegers2(array);
//        System.out.println(array);

        test t1 = new test();

//        System.out.println(t1.binarySearch(sorted_array,3));

//        TreeNode head = buildTree();
//        List rst = new ArrayList();
//        System.out.println(t1.levelOrder(head));

//        ListNode head = buildNode();
//        ListNode head1 = t1.insertionSortList(head);
//        while(head1!=null){
//            System.out.println(head1.val);
//            head1 = head1.next;
//
//        }
//        Solution s1 = t1.new Solution();
//        int [] a = {3, 2, 2, 1, 4};
//        int[] result = s1.partition(a,0,4,2);
//        for (int x : result) {
//            System.out.println(x);
//        }
        int [][] matrix = {{1,1,0,0,0},{0,1,0,0,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,0,0,1}};
        boolean[][] grid  = new boolean[100][100];
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    grid[i][j]=false;
                }else{
                    grid[i][j]=true;
                }
                System.out.println(grid[i][j]);
            }
        }
        Solution s1 = t1.new Solution();


        System.out.println(s1.numIslands(grid));
    }

     class NumberCompare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
    class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    public  class Solution{
        public class coor{
            int x,y;
            public coor(int x,int y){
                this.x = x;
                this.y = y;
            }
        }

        public int numIslands(boolean[][] grid) {
            // write your code here
            //BFS
            int count = 0;
            int[]adjX = {1,0,0,-1};
            int[]adjY = {0,-1,1,0};

            for (int i = 0;i<grid.length;i++){
                for (int j = 0;j<grid[i].length;j++){

                    if (grid[i][j]){
                        helper(grid,new coor(i,j),adjX,adjY); //BFS set all adj to false

                        count++; //no adj still island
                    }
                }
            }
            return count;
        }
        private void helper(boolean[][] grid,coor cor,int[]adjX,int[]adjY){

            Queue<coor> queue = new LinkedList<>();


            queue.offer(cor);
            grid[cor.x][cor.y] = false;
            while(!queue.isEmpty()){
                coor coor = queue.poll(); //curren cor
                for (int i = 0; i < 3; i++) {
                    coor adj = new coor( //current adj coordiate
                            coor.x+adjX[i],
                            coor.y+adjY[i]
                    );
                    if (!inBound(adj,grid)){
                        continue;
                    }
                    if (grid[adj.x][adj.y]){
                        grid[adj.x][adj.y]=false;
                        queue.offer(adj);
                    }
                }
            }





        }
        private boolean inBound(coor coor, boolean[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
        }


//        public int kthLargestElement(int k, int[] nums) {
//            if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
//                return -1;
//            }
//            return partition(nums, 0, nums.length - 1, nums.length - k);
//        }

        public int[] partition(int[] nums, int start, int end, int k) {
            if (start >= end) {
                return nums;
            }

            int left = start, right = end;
            int pivot = nums[(start + end) / 2];

            while (left <= right) {
                while (left <= right && nums[left] < pivot) {
                    left++;
                }
                while (left <= right && nums[right] > pivot) {
                    right--;
                }
                if (left <= right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }

//            if (k <= right) {
//                return partition(nums, start, right, k);
//            }
//            if (k >= left) {
//                return partition(nums, left, end, k);
//            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public void sortColors2(int[] colors, int k) {
            // write your code here
            if (colors==null||colors.length<1){
                return;
            }
            int l = 0;
            int r = 0;
            int tar = 0;
            while(l<colors.length || tar >k){
                 if(r>colors.length-1){
                    tar +=1;
                    r = l;
                }else if (colors[r]!=tar){
                    r++;
                }
                else if (colors[r]==tar){
                    int temp = colors[l];
                     colors[l] = colors[r];
                     colors[r] = temp;
                    l++;
                    r++;
                }

            }
        }






        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(strs, new NumberCompare());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }
            String result = sb.toString();
//            int index = 0;
//            while (index < result.length() && result.charAt(index) == '0') {
//                index++;
//            }
//            if (index == result.length()) {
//                return "0";
//            }
            return result;
        }
    }

    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x){
            this.val = x;
            this.left = null ;
            this.right = null ;

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
    public static ListNode buildNode(){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        return node1;
    }
    public static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;

            System.out.println("head ; " + head.val);
            System.out.println("node : " + node.val);
            System.out.println("head.next : "+ head.next.val);
            System.out.println("node.next : " + node.next.val);
        }

        return dummy.next;
    }





        public List<List<Integer>> levelOrder(TreeNode root) {
            List result = new ArrayList();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    level.add(head.val);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
                result.add(level);
            }

            return result;
        }


    public int binarySearch(int[] array,int target){
        if (array==null||array.length==0){
            return -1;
        }
        int start = 0;
        int end  = array.length-1;
        int mid = start+(end-start)/2;
        while(start+1<end){
            mid = start+(end-start)/2;
            if (array[mid]==target){
                end = mid;
            }else if (target>array[mid]){
                start = mid;
            }else   {
                end = mid;
            }
        }
        if (target==array[end]){
            return end;
        }
        if (target==array[start]){
            return start;
        }
        return -1;
    }

    public void sortIntegers2(int[] A) {
        // write your code here
        mergeSort(A,0,A.length);
    }

    private void mergeSort (int[] array,int left,int right){
        if (left>=right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,right); //merge two arrays
    }
    private void merge(int[] array,int left,int right){
        int [] temp = new int [right-left+1]; //result array;
        int mid = left + (right-left)/2;
        int i = left, j = mid+1; //keep boundaries of two arrays

        for (int k = 0;k<temp.length;k++){
            if (left<=j&&(mid+1>right||array[left]<array[mid])){
                temp[k] = array[left];
                left++; //left shift right
            }else   {
                temp[k] = array[mid];
                mid++; //mid (second array) index shift right
            }

        }
        for (int k = 0; k < right - i + 1; ++k) {
            array[i + k] = temp[k];
        }
    }

}
