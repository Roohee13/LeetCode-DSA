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
    int ans=0;
    public int longestUnivaluePath(TreeNode root) {
        search(root);
        return ans;
    }

    public int search(TreeNode node){
        if(node== null) return 0;

        int left= search(node.left);
        int right= search(node.right);

        if(node.left != null && node.left.val==node.val){
            left++;

        }else{
            left=0;
        }

         if(node.right != null && node.right.val==node.val){
            right++;

        }else{
            right=0;
        }

        ans= Math.max(left+right,ans);
        return Math.max(right,left);

    }
}