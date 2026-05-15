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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode root) {
        int heightLeft = 0, heightRight = 0;

        if (root == null) {
            return 0;
        }

        heightLeft = height(root.left);
        heightRight = height(root.right);

        int diameter = heightLeft + heightRight;

        maxDiameter = Math.max(maxDiameter, diameter);

        return 1 + Math.max(heightLeft, heightRight);
    }
}
