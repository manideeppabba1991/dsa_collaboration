import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinarySearchTree {
    public static void main(String[] args) {

        TreeNode bottomLeftleaf = new TreeNode(1);
        TreeNode bottomRightleaf = new TreeNode(3);
        TreeNode Level1LeftNode = new TreeNode(2, bottomLeftleaf, bottomRightleaf);
        TreeNode Level1RightNode = new TreeNode(7);
        TreeNode root = new TreeNode(4, Level1LeftNode, Level1RightNode);
        System.out.println("My TreeNode: " + root);

        List<Integer> preOrderOutput = new ArrayList<>();
        List<Integer> preOrderTraversal = preOrder(root, preOrderOutput);
        System.out.println("Pre-Order Traversal: " + preOrderTraversal);

        List<Integer> inOrderOutput = new ArrayList<>();
        List<Integer> inOrderTraversal = inOrder(root, inOrderOutput);
        System.out.println("In-Order Traversal: " + inOrderTraversal);

        List<Integer> postOrderOutput = new ArrayList<>();
        List<Integer> postOrderTraversal = postOrder(root, postOrderOutput);
        System.out.println("Post-Order Traversal: " + postOrderTraversal);

        // hasPathSum --- https://leetcode.com/problems/path-sum/
        int targetSum = 7;
        boolean hasPathSum = hasPathSum(root, targetSum);
        System.out.println("Is target sum achieved: " + hasPathSum);


        // Used Set to remove duplicates (left & right nodes of leafnodes --- base condition) ---> sum from root to leaf
        int sum = 0;
        Set<Integer> output = new HashSet<Integer>();
        output = sumFromRootToLeaf(root, sum, output);
        System.out.println("Sum of all Root to Leaf nodes: " + output);

        int searchElement = 2;
        TreeNode result = searchBST(root, searchElement);
        System.out.println("Result: " + result);

        List<Integer> bfsResult = breadthFirstSearchApproach(root);
        System.out.println("Display tree: " + bfsResult);

        List<List<Integer>> levelOrderResults = levelOrder(root);
        System.out.println("Level Order Results: " + levelOrderResults);

        List<Integer> rightSideResults = rightSideView(root);
        System.out.println("Right side view Results: " + rightSideResults);

        List<List<Integer>> zigzagLevelResults = zigzagLevelOrder(root);
        System.out.println("Zig Zag level Results: " + zigzagLevelResults);

    }

    private static Set<Integer> sumFromRootToLeaf(TreeNode root, int sum, Set<Integer> output) {
        //base condition
        if(root == null) {  // TC = O(n) and SC = O(n) as recursive stack is being used
            output.add(sum);
        }

        if(root != null) { 
            sumFromRootToLeaf(root.left, sum + root.val, output);
            sumFromRootToLeaf(root.right, sum + root.val, output);
        }

        return output;
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        // base condition
        if (root == null) {  // TC = O(n) and SC = O(n) as recursive stack is being used
            return false;
        }

        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private static List<Integer> postOrder(TreeNode root, List<Integer> output) {
          //base condition
        if(root == null) { // TC = O(n) and SC = O(n) as recursive stack is being used
            return null;
        }

        postOrder(root.left, output);        
        postOrder(root.right, output);
        output.add(root.val);

        return output;
    }

    private static List<Integer> inOrder(TreeNode root, List<Integer> output) {
         //base condition
        if(root == null) { // TC = O(n) and SC = O(n) as recursive stack is being used
            return null;
        }

        inOrder(root.left, output);
        output.add(root.val);
        inOrder(root.right, output);

        return output;
    }

    private static List<Integer> preOrder(TreeNode root, List<Integer> output) {
        //base condition
        if(root == null) { // TC = O(n) and SC = O(n) as recursive stack is being used
            return null;
        }
        output.add(root.val);

        preOrder(root.left, output);
        preOrder(root.right, output);

        return output;
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            List<Integer> nodesAtEachLevel = new ArrayList<>();
            int size = treeQueue.size();
            while (size > 0) {
                TreeNode currentTreeNode = treeQueue.remove();
                nodesAtEachLevel.add(currentTreeNode.val);
                if (currentTreeNode.left != null) {
                    treeQueue.add(currentTreeNode.left);
                }
                if (currentTreeNode.right != null) {
                    treeQueue.add(currentTreeNode.right);
                }
                size--;
            }
            int level = result.size();
            if (level % 2 == 0) {
                result.add(nodesAtEachLevel);
            } else {
                List<Integer> reversedNodesAtEachLevel = new ArrayList<>();
                for (int i = nodesAtEachLevel.size() - 1; i >= 0; i--) {
                    reversedNodesAtEachLevel.add(nodesAtEachLevel.get(i));
                }
                result.add(reversedNodesAtEachLevel);
            }
        }
        return result;
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            List<Integer> nodesAtEachLevel = new ArrayList<>();
            int size = treeQueue.size();
            while (size > 0) {
                TreeNode currTreeNode = treeQueue.remove();
                nodesAtEachLevel.add(currTreeNode.val);
                //System.out.println("Nodes at each level: " + nodesAtEachLevel.toString());
                if (currTreeNode.left != null) {
                    treeQueue.add(currTreeNode.left);
                }
                if (currTreeNode.right != null) {
                    treeQueue.add(currTreeNode.right);
                }
                size--;
            }
            if (nodesAtEachLevel.size() > 0) {
                result.add((nodesAtEachLevel.get(nodesAtEachLevel.size() - 1)));
            }
        }
        return result;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            List<Integer> nodesAtEachLevel = new ArrayList<>();
            int size = treeQueue.size();
            while (size > 0) {
                TreeNode currentTreeNode = treeQueue.remove();
                nodesAtEachLevel.add(currentTreeNode.val);
                if (currentTreeNode.left != null) {
                    treeQueue.add(currentTreeNode.left);
                }
                if (currentTreeNode.right != null) {
                    treeQueue.add(currentTreeNode.right);
                }
                size--;
            }
            if (!nodesAtEachLevel.isEmpty()) {
                result.add(nodesAtEachLevel);
            }
        }
        return result;
    }

    private static List<Integer> breadthFirstSearchApproach(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.remove();
            result.add(currentTreeNode.val);
            if (currentTreeNode.left != null) {
                queue.add(currentTreeNode.left);
            }
            if (currentTreeNode.right != null) {
                queue.add(currentTreeNode.right);
            }
        }
        return result;
    }

    // Recursive approach
    private static TreeNode searchBST(TreeNode root, int val) {
        // break/base conditions
        if (root == null) {
            return null;
        } else if (val == root.val) { // TC = O(log n) since we are using divide and conquer approach, SC = O(log n),
                                      // since stack is used for recursion
            return root;
        }

        else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode [val= " + val + ", \n left=" + left + ", \n right=" + right + "] \n";
    }

}
