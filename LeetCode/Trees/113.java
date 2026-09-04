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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> l =new ArrayList<>();
        fun(root, targetSum, 0, l, new ArrayList<>());

        return l;
    }

    private void fun(TreeNode root, int targetSum, int sum, List<List<Integer>> l, List<Integer> temp){
        if(root== null) return ;

        sum= sum + root.val;
        temp.add(root.val);

        if(root.left== null && root.right== null){
            if(sum==targetSum){
                l.add(new ArrayList<>(temp));
            }
        }

        fun(root.left, targetSum, sum, l, temp);
        fun(root.right, targetSum, sum, l, temp);
        temp.remove(temp.size()-1);
    }
}
