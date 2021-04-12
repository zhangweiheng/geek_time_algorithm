class Solution {
  public int[][] merge(int[][] intervals) {
    // 先按照第一个元素排序，然后再归并所有区间
    if (intervals == null || intervals.length <= 0) return new int[0][0];
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> ans = new LinkedList<>();
    for (int[] interval : intervals) {
      if (ans.isEmpty() || ans.getLast()[1] < interval[0]) ans.add(interval);
      else ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
    }
    return ans.toArray(new int[ans.size()][]);
  }
}