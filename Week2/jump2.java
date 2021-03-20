class Solution {
    // https://www.youtube.com/watch?v=Ua_Vqtdd61E BFS
    // https://www.youtube.com/watch?v=XMcuEGATxBE Greddy
    public int jump(int[] nums) {
      int cur = 0, max = 0, step = 0;
      for (int i = 0; i < nums.length - 1; ++i) {
        // keep on updating right bound 而且右界是包括的，所以要先计算在移位
        max = Math.max(max, i + nums[i]);
        
        if (i == cur) {
          cur = max;
          step++;
        }
        
        
      }
      
      return step;
    }
}