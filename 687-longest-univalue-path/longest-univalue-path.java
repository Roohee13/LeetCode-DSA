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

int maxPath=0;
    public int longestUnivaluePath(TreeNode root) {
        
        if(root==null) return 0;
        search(root);
        return maxPath;

    }

    public int search(TreeNode node){
        if(node== null) return 0;
        int leftdown= search(node.left);
        int rightdown= search(node.right);
        
        int left=0,right=0;
        if(node.left!= null && node.left.val== node.val){
            left= leftdown+1;
        }

        if(node.right!= null && node.right.val==node.val){
            right=rightdown+1;
        }

        maxPath= Math.max(left+right,maxPath);
        return Math.max(left,right);
    }
}