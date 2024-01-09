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
    List<Integer> arr1;
    List<Integer> arr2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        arr1 = new ArrayList();
        arr2 = new ArrayList();
        if(root1 == null || root2 == null) return false;
        
        helper(root1, arr1);
        helper(root2, arr2);
        
        return arr1.equals(arr2);
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> leaves){
        //base
        if(root == null) return leaves;
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        }
        
        helper(root.left, leaves);
        helper(root.right, leaves);
        
        return leaves;
    }
}