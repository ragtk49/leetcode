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
    HashMap<Integer, Integer> map;
    int preOrderIdx = 0;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return binaryTree(0, preorder.length-1);
    }
    
    private TreeNode binaryTree(int left, int right){
        if(left > right) return null;
        
        int rootVal = preorder[preOrderIdx];
        preOrderIdx++;
        TreeNode root = new TreeNode(rootVal);
        
        root.left = binaryTree(left, map.get(rootVal) - 1);
        root.right = binaryTree(map.get(rootVal) + 1, right);
        
        return root;
    }
}