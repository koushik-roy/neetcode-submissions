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
     int count=0;
    public int goodNodes(TreeNode root) {     
        
        dfs(root, root.val);
        return count;

    }

    public void dfs(TreeNode node, int currMax) {
        if (node == null) {
            return;
        }
        
        if (node.val >= currMax) {
            count++;
        }
        int newMax = Math.max(node.val, currMax);
        dfs(node.left, newMax);
        dfs(node.right, newMax);
    }
}
