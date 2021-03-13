class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) map.put(num, map.get(num) + 1);
      else map.put(num, 1);
    }
    
    PriorityQueue<Integer> heap = new PriorityQueue<>(
      (n1, n2) -> map.get(n2) - map.get(n1)
    );
    
    for (Integer num : map.keySet()) {
      heap.offer(num);
    }
      
    int[] ans = new int[k];
    for (int i = 0;i < k; ++i) {
      ans[i] = heap.poll();
    }
      
    return ans;
    
  }
}