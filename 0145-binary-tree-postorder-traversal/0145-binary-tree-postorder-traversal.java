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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack();
        
        TreeNode curr = root;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            res.add(0,top.val);
            if(top.left != null){
                stack.push(top.left);
            }
            if(top.right != null){
                stack.push(top.right);
            }
        }
        return res;
        
    }
}