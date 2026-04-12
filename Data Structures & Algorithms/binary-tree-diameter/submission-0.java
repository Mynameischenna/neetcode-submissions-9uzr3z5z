/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int mx;
    public int diameterOfBinaryTree(TreeNode root) {
        mx = 0;
        diameter(root);
        return mx;
    }
    private int diameter(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = 0, right = 0;
        left = diameter(root.left);
        right = diameter(root.right);
        mx = Math.max(mx, left + right);
        return Math.max(left, right) + 1;
    }
}
