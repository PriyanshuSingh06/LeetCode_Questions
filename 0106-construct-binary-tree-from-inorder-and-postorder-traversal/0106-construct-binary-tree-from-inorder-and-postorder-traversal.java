import java.util.*;

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // Store inorder values and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from last element of postorder
        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        // No elements left
        if (left > right) {
            return null;
        }

        // Create root
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int mid = map.get(rootVal);

        // Important: build right first because postorder goes backwards
        root.right = build(inorder, postorder, mid + 1, right);

        root.left = build(inorder, postorder, left, mid - 1);

        return root;
    }
}