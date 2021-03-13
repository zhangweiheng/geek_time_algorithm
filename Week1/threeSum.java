class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums == null || nums.length < 3) return ans;
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; ++i) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i] == nums[i - 1]) continue; 
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum < 0) 
          while (left < right && nums[left] == nums[++left]);
        else if (sum > 0)
          while (left < right && nums[right] == nums[--right]);
        else {
          ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[++left]);
          while (left < right && nums[right] == nums[--right]);
        }
      }
    }
    
    return ans;
  }
}