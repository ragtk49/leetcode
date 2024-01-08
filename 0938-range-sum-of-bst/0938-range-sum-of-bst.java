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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int sum = 0;

        // In-order traversal using a stack
        while (current != null || !stack.isEmpty()) {
            // Push left children onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            // If the current node's value is within the range, add it to the sum
            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }

            // If the current value exceeds 'high', break the loop as all remaining nodes will be greater
            if (current.val > high) break;

            // Move to the right child
            current = current.right;
        }

        return sum;
    }
}