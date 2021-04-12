class Solution {
  public int myAtoi(String s) {
    // s.trim().length() <= 0 要加这个以防就是一堆空格的空串。
    if (s == null || s.length() <= 0 || s.trim().length() <= 0) return 0;
    
    s = s.trim();
    int sign = s.charAt(0) == '-' ? -1 : 1;
    long value = 0L;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (i == 0 && (c == '+' || c == '-')) continue;
      if (!isDigit(c)) break;
      
      value = value * 10 + (c - '0');
      if (value * sign >= (long) Integer.MAX_VALUE) return Integer.MAX_VALUE;
      if (value * sign <= (long) Integer.MIN_VALUE) return Integer.MIN_VALUE;    
    }
    
    return sign * (int) value;
  }
  
  private boolean isDigit(char c) {
    return c >= '0' && c <= '9' ; 
  }
}