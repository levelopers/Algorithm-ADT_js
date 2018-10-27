class MyStack {

    /** Initialize your data structure here. 
    
    https://leetcode.com/problems/implement-stack-using-queues/
    
    */
    public MyStack() {
        
    }
    
     /*
     * @param x: An integer
     * @return: nothing
     */
     
     Queue<Integer> queue1 = new LinkedList<>();
     Queue<Integer> queue2 = new LinkedList<>();
     
    private void move(){
        while (queue1.size()>1){
            queue2.offer(queue1.poll());
        } 
    }
    
    private void swapQueue(){
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public int pop() {
        
        move();
       int popItem= queue1.poll();
        swapQueue();
        return popItem;
    }

    /*
     * @return: An integer
     */
    public int top() {
        
        move();
        int topItem = queue1.poll();
        swapQueue();
        queue1.offer(topItem);
        return topItem;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean empty() {
       
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */