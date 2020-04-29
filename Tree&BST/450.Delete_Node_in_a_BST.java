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
//Really tedious own method
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //First find the node
        TreeNode deletenode = root, dltnodeprt = null;
        int flag = 0; //If we find the key, flag = 1;
        while(deletenode != null) {
            if(key == deletenode.val) {
                flag = 1;
                break;
            } else if (key < deletenode.val) {
                dltnodeprt = deletenode;
                deletenode = deletenode.left;
            } else {
                dltnodeprt = deletenode;
                deletenode = deletenode.right;
            }
        }
        //If we cannot find it return root(Do nothing)
        if(flag == 0) {
            return root;
        } else { //else we delete the node
            //Three cases in deletion:
            //1.The node to be deleted has no child - The node's parent point to null
            if(deletenode.left == null && deletenode.right == null) {
                if(dltnodeprt != null) {
                    if(dltnodeprt.left == deletenode) {
                        dltnodeprt.left = null;
                    }
                    if(dltnodeprt.right == deletenode) {
                        dltnodeprt.right = null;
                    }
                } else {
                    return null;
                }
            }
            //2.The node to be deleted has one child - Link its child to its parent
            if(deletenode.left != null && deletenode.right == null) {
               if(dltnodeprt != null) {
                   if(dltnodeprt.left == deletenode) {
                        dltnodeprt.left = deletenode.left;
                    }
                    if(dltnodeprt.right == deletenode) {
                        dltnodeprt.right = deletenode.left;
                    }
               } else {
                   return deletenode.left;
               }
            }
            if(deletenode.left == null && deletenode.right != null) {
                if(dltnodeprt != null) {
                    if(dltnodeprt.left == deletenode) {
                        dltnodeprt.left = deletenode.right;
                    }
                    if(dltnodeprt.right == deletenode) {
                        dltnodeprt.right = deletenode.right;
                    }
                } else {
                    return deletenode.right;
                }
            }
            //3.The node to be deleted has two child - Replace it with the next biggest element
            //The MOST important thing is to find the next biggest element
            //- Read the right child of the node to be deleted and find the left leaf of it
            if(deletenode.left != null && deletenode.right != null) {
                TreeNode dltnoderight = deletenode.right, nextbiggest = dltnoderight, nextbiggestprt = deletenode;
                int i = 0;
                while(dltnoderight != null) {
                    i++;
                    if(i >= 2) {
                        nextbiggestprt = nextbiggest;
                    }
                    nextbiggest = dltnoderight;
                    dltnoderight = dltnoderight.left;
                }
                deletenode.val = nextbiggest.val;
                if(nextbiggest.right != null && deletenode.right == nextbiggest) {
                    nextbiggestprt.right = nextbiggest.right;
                }
                if(nextbiggest.right != null && nextbiggestprt.left == nextbiggest) {
                    nextbiggestprt.left = nextbiggest.right;
                }
                if(nextbiggest.right == null && nextbiggestprt.right == nextbiggest) {
                    nextbiggestprt.right = null;
                }
                if(nextbiggest.right == null && nextbiggestprt.left == nextbiggest) {
                    nextbiggestprt.left = null;
                }
            }
            return root;
        }
    }
}