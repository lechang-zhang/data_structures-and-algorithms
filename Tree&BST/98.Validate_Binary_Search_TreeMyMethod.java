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
    public boolean isValidBST(TreeNode root) {
        //Inroder traversal and everytime check if the current is bigger than the element before
        if(root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int i = -1;
        while(root != null || !stack.empty()) {
            i++;
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            if(i != 0) {
                if(list.get(i) <= list.get(i - 1)) {
                    return false;
                }
            }
            root = root.right;
        }
        return true;
    }
}