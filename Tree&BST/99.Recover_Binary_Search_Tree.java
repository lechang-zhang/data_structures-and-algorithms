/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        //Find the mistake in BST by inorder traversal first
        //Swap the two elements
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode FirstMistake = null, SecondMistake = null;
        int flag = 0;
        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val > root.val && flag != 1) {
                FirstMistake = pre;
                flag = 1;
            }
            if(pre != null && root.val < pre.val) {
                SecondMistake = root;
            }
            pre = root;
            root = root.right;
        }
        int temp = FirstMistake.val;
        FirstMistake.val = SecondMistake.val;
        SecondMistake.val = temp;
    }
}