class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (wordList == null || wordList.size() <= 0 || endWord == null || beginWord == null) return 0;
    
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;
    
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>(); 
    beginSet.add(beginWord);
    endSet.add(endWord);
    wordSet.remove(beginWord);
    int ans = 0;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      ans ++;
      
      // 互换，只遍历小的set
      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }
      
      // 生成一个新set, 把结果都加进去
      Set<String> temp = new HashSet<>();
      for (String currentWord : beginSet) {
        char[] chars = currentWord.toCharArray();
        for (int j = 0; j < chars.length; ++j) {
          char currentChar = chars[j];
          for (char c = 'a'; c <= 'z'; ++c) {
            chars[j] = c;
            String newStr = String.valueOf(chars);
            if (endSet.contains(newStr)) {
              return ans + 1;
            }
            if (wordSet.contains(newStr)) {
              temp.add(newStr);
              wordSet.remove(newStr);
            }
          }
          chars[j] = currentChar;
        }
      }
      beginSet = temp;
      
    }
    
    return 0;
  }
}