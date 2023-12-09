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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> righSide = new ArrayList<>();
        Queue<TreeNode> ques = new LinkedList<>();
        ques.add(root);

        while(!ques.isEmpty()){
            int len = ques.size();

            while(len >0){
                TreeNode current = ques.poll();
                if(len ==1){
                    righSide.add(current.val);
                }
                if(current.left != null)
                    ques.add(current.left);
                if(current.right != null)
                    ques.add(current.right);
                len--;
                
            }
        }

        return righSide;
    }
}
