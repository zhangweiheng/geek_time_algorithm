class Solution {
  // dfs will exceed the time
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 0) return false;  
    return dfs(nums, 0);
  }
  
  private boolean dfs(int[] nums, int level) {
    if (level >= nums.length - 1) {
      return true;
    }
    
    for (int i = 1; i <= nums[level]; ++i) {
      if (dfs(nums, level + i)) {
        return true;
      }
    }
    
    return false;
  } 
}