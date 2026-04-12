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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        lcs(root, p, q);
        return ans;
    }
    private boolean lcs(TreeNode root,TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean r = false;
        if (root.val == p.val || root.val == q.val) r = true;

        boolean left = false;
        if (p.val < root.val || q.val < root.val) left = lcs(root.left, p, q);
        boolean right = false;
        if (p.val > root.val || q.val > root.val) right = lcs(root.right, p, q);
        
        if (left && right || left && r || right && r) if (ans == null) ans = root;
        return left || right || r;
    }
}
