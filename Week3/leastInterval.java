class Solution {
  // Approach 2: Math
  // 其实关键就在于要看执行最多得哪个Task在平摊之后要不要插入任何闲置，如果不需要，那实际就是总的task数量。国内站得解释还不错。
  public int leastInterval(char[] tasks, int n) {
    int length = tasks.length;
    int[] count = new int[26];
    int max = 0;
    for (char c : tasks) {
      max = Math.max(max, ++count[c - 'A']);
    }
    int maxCount = 0;
    for (int num : count) {
      if (num == max) maxCount++;
    }
    
    return length >= (max - 1) * (n + 1) + maxCount ? length : (max - 1) * (n + 1) + maxCount;
  }
}