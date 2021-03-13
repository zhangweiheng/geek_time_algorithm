class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> cureentLevel = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        Node node = queue.poll();
        cureentLevel.add(node.val);
        List<Node> children = node.children;
        if (children != null && children.size () > 0) {
         for (Node child : children) {
           queue.offer(child);
         }
        }
      }
      ans.add(cureentLevel);
    }
    
    return ans;

  }
}