//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> zigzagOut = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        boolean isLeft = true;
        while(!nodeQueue.isEmpty()){
            List<Integer> levelOut = new ArrayList<>();
            int len = nodeQueue.size();
            
            while(len > 0){
                TreeNode cur = nodeQueue.poll();

                if(isLeft){
                    levelOut.add( cur.val);
                }else{
                    levelOut.add(0,cur.val);
                }
                if(cur.left != null)
                    nodeQueue.add(cur.left);
                if(cur.right != null)
                    nodeQueue.add(cur.right);
                len--;
            }
            zigzagOut.add(levelOut);
            isLeft = !isLeft;
        }
        return zigzagOut;
    }
}
