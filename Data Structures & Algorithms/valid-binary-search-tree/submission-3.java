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
    long minBound = Long.MIN_VALUE, maxBound = Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
       return dfs(root, minBound, maxBound);
    }

    public boolean dfs(TreeNode node, long minBound, long maxBound) {
        if (node == null) {
            return true;
        }

        if (node.val >= maxBound || node.val <= minBound) {
            return false;
        }

        return dfs(node.left, minBound, node.val) &&
                dfs(node.right, node.val, maxBound);

    }

}