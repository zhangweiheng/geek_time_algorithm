class Solution {
  // 循环每一个字符，以其为中心向外扩散，并且分奇偶两种情况扩散。
  private int count = 0;
  
  public int countSubstrings(String s) {
    for (int i = 0; i < s.length(); ++i) {
      checkPalindromic(i, i, s);
      checkPalindromic(i, i + 1, s);
    }  
    return count;
  }
  
  private void checkPalindromic (int left, int right, String s) {
    while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
      count ++;
      left --;
      right ++;
    }
  }
  
}

class Solution {
  // 动态规划解法，dp[i] = dp[i - 1] + {包括他得所有回文子串得数量}
  public int countSubstrings(String s) {
    int n = s.length();
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; ++i) {
      for (int j = 0; j < i; ++j) {
        if (isPalindromic(s.substring(j, i))) {
          dp[i] += 1;
        }
      }
      dp[i] += dp[i - 1];
    }
      
    return dp[n];
  }
  
  private boolean isPalindromic(String s) {
    if (s.equals("")) return true;
    for (int i = 0; i < s.length() / 2; ++i)
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
      
    return true;
  }
}