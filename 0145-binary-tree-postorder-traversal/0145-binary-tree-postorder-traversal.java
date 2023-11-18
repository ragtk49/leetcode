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
        List<Integer> res = new LinkedList<>();
        //Base case
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }else{
                TreeNode top = stack.peek();
                if(top.right == null || top.right == pre){
                    res.add(top.val);
                    stack.pop();
                    pre = top;
                    cur = null; //Don't traverse the left again
                }else{
                    cur = top.right;
                }
            }
        }
        return res;
    }
}