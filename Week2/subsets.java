class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(ans, nums, 0, new ArrayList());
    return ans;
  }
  
  private void helper (List<List<Integer>> ans, int[] nums, int level, List<Integer> tempList) {
    if (level == nums.length) {
      ans.add(new ArrayList(tempList));
      return;
    }
    
    helper(ans, nums, level + 1, tempList);
    tempList.add(nums[level]);
    helper(ans, nums, level + 1, tempList); 
    tempList.remove(tempList.size() - 1);
  }
  
}