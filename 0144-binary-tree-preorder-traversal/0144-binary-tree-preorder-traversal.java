class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        display(root, ans);
        return ans;
    }

    private void display(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        display(root.left, ans);
        display(root.right, ans);
      
        
        
    }
}