class Solution {
  public int minMutation(String start, String end, String[] bank) {
    // 双向BFS
    if (start == null || end == null || bank == null || bank.length <= 0) return -1;
    
    Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
    if (!wordSet.contains(end)) return -1;
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    
    char[] genes = new char[]{'A', 'C', 'G', 'T'};
    beginSet.add(start);
    endSet.add(end);
    int ans = 0;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      ans ++;
      
      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      } 
      
      Set<String> temp = new HashSet<>();
      for (String currentGene: beginSet) {
        char[] chars = currentGene.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
          char c = chars[i];
          for (char gene: genes) {
            chars[i] = gene;
            String newGene = String.valueOf(chars);
            if (endSet.contains(newGene)) {
              return ans;
            }
            if (wordSet.contains(newGene)) {
              temp.add(newGene);
              wordSet.remove(newGene);
            }
          }
          chars[i] = c;
        }
      }
      beginSet = temp;
    }
    
    return -1;
  }
}