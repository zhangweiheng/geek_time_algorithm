class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    helper (ans, nums, 0, new boolean[nums.length], new ArrayList());
    return ans;
  }
  
  private void helper (List<List<Integer>> ans, int[] nums, int level, boolean[] duplicate, List<Integer> tempList) {
    if (level == nums.length) {
      ans.add(new ArrayList<>(tempList));
      return;
    }  
    
    for (int i = 0; i < nums.length; ++i) {
      if (duplicate[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !duplicate[i - 1]) continue;
      
      tempList.add(nums[i]);
      duplicate[i] = true;
      helper (ans, nums, level + 1, duplicate, tempList);
      tempList.remove(tempList.size() - 1);
      duplicate[i] = false;
    }
    
  }
  
}