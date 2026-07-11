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
    boolean state = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return state;
    }

    public void dfs(TreeNode node, int minBound, int maxBound) {
        if (node == null) {
            return;
        }
        if (node.val >= maxBound || node.val <= minBound) {
            state = false;
        }
        dfs(node.left, minBound, node.val);
        dfs(node.right, node.val, maxBound);
    }
}
