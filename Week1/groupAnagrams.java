class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> ans = new HashMap<>();
      for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = String.valueOf(chars);
        if(ans.get(key) == null) ans.put(key, new ArrayList());
        ans.get(key).add(str);
      }
      return new ArrayList(ans.values());
    }
}