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
    public TreeNode sortedArrayToBST(int[] nums) {
        //EMPTY array case
        if(nums.length == 0) {
            return null;
        }
        return ToBST(nums, 0, nums.length - 1);
    }
    //Recursively insert parent, left child and right child
    public TreeNode ToBST(int[] nums, int low, int high) {
        //Recursion boundary
        if(high < low) {
            return null;
        }
        
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = ToBST(nums, low, mid - 1);
        root.right = ToBST(nums, mid + 1, high);
        
        return root;
    }
}
    