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
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        this.preorder=preorder;
        return build(0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = build(preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}
