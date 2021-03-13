class MinStack {
    
    private Stack<Integer> stack;
    private Stack<int[]> minStack;

    /** initialize your data structure here. */
    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }
    
    public void push(int x) {
      stack.push(x);
      if (minStack.isEmpty() || minStack.peek()[0] > x) minStack.push(new int[] {x, 1});
      else if (minStack.peek()[0] == x) minStack.peek()[1]++;  
    }
    
    public void pop() {
      int x = stack.pop();
      if (!minStack.isEmpty() && minStack.peek()[0] == x) {
        minStack.peek()[1]--;
        if (minStack.peek()[1] == 0) minStack.pop();
      }
    }
    
    public int top() {
      return stack.peek();
    }
    
    public int getMin() {
      return minStack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */