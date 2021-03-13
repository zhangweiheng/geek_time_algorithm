class Solution {
    // So it actually find the left and right boundry using the stack. push the inital -1 because don't need to check empty all the time and can use the same pattern (i - peek() - 1) to get the width.
    public int largestRectangleArea(int[] heights) {
      int ans = 0, n = heights.length;
      Stack<Integer> stack = new Stack<>();
   
      for (int i = 0; i < n; ++i) {
        while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
          int currentHeight = heights[stack.pop()];
          int currentWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
          ans = Math.max(ans, currentHeight * currentWidth);
        }
        stack.push(i);
      }
      
      while (!stack.isEmpty()) {
        int currentHeight = heights[stack.pop()];
        int currentWidth = stack.isEmpty() ? n : n - stack.peek() - 1;
        ans = Math.max(ans, currentHeight * currentWidth);
      }
      
      return ans;
    }
}