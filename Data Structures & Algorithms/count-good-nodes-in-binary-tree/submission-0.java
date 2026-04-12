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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return good(root, Integer.MIN_VALUE);
    }
    private int good(TreeNode root, int maxValue) {
        if (root == null) return 0;
        int c = 0;
        if (root.val >= maxValue) c = 1;
        maxValue = Math.max(maxValue, root.val);

        int left = good(root.left, maxValue);
        int right = good(root.right, maxValue);

        return left + right + c;
    }
}
