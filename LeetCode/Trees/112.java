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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return fun(root, targetSum, 0);
    }

    private boolean fun(TreeNode root, int targetSum, int sum){
        if(root== null){
            return false;
        }

        sum= sum+ root.val;

        if(root.left == null && root.right == null){
            return sum== targetSum;
        }

        boolean b1= fun(root.left, targetSum, sum);
        boolean b2= fun(root.right, targetSum, sum);

        return b1||b2;
    }
}
