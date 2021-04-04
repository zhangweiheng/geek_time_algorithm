public class Solution {
  // you need treat n as an unsigned value
  //https://www.youtube.com/watch?v=K0EHvvbUdEg
  // 当n是负数得时候，就必须要用位操作符了，看视频。而且终止条件不可以是n == 0，剩余得0必须也得补上。记住要执行32次即可。
  public int reverseBits(int n) {
    int ans = 0;
    for (int i = 0; i < 32; ++i) {
      ans = (ans << 1) | (n & 1); // ans << 1 == n * 2. n & 1 == n % 2 
      n >>= 1;
    }
    return ans;
  }
}