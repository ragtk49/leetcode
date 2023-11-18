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
    final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfs(root) != UNBALANCED;
    }

    private int dfs(TreeNode root){
        //base case
        if(root.left == null && root.right == null) return 1;

        //left subtree dfs
        int leftH = 0;
        if(root.left != null){
            leftH = dfs(root.left);
        }
        if(leftH == UNBALANCED) return UNBALANCED;

        //right subtree dfs
        int rightH = 0;
        if(root.right != null){
            rightH = dfs(root.right);
        }
        if(rightH == UNBALANCED) return UNBALANCED;

        //check current tree
        if(Math.abs(rightH - leftH) <= 1) return Math.max(rightH, leftH) + 1;

        return UNBALANCED;


    }
}