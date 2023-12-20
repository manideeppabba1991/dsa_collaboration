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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        //base condition
        if(root == null) {
            return sum;
        }
        sum = sumNumbersHelper(root, sum);
        return sum;
    }

    public int sumNumbersHelper(TreeNode root, int sum) {
        if(root == null) {
            return sum;
        }
        //if leaf node
        if(root.left == null && root.right == null) {
            return sum + root.val;
        }

        sum += root.val;
        int leftValue = 0;
        int rightValue = 0;
        if(root.left != null) {
            leftValue = sumNumbersHelper(root.left, sum * 10);
        }
        if(root.right != null) {
            rightValue = sumNumbersHelper(root.right, sum * 10);
        }
        return leftValue + rightValue;
    }
}