class Solution {
    LinkedList<Integer> dequeue = new LinkedList<>();
  
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      int[] ans = new int[n - k + 1];
      
      for (int i = 0; i < n; ++i) {
        removeFromQueue(nums, k, i);
        dequeue.offerLast(i);
        if (i - k + 1 >= 0) {
          ans[i - k + 1] = nums[dequeue.peekFirst()];
        }
      }
      
      return ans;
    }
  
  private void removeFromQueue (int[] nums, int k, int i) {
    if (!dequeue.isEmpty() && i - k == dequeue.peekFirst()) 
      dequeue.pollFirst();
    
    
    while (!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]) 
      dequeue.pollLast();
  }
}