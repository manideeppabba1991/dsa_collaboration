import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    public static void main(String[] args) {

        TreeNode bottomLeftleaf = new TreeNode(1);
        TreeNode bottomRightleaf = new TreeNode(3);
        TreeNode Level1LeftNode = new TreeNode(2, bottomLeftleaf, bottomRightleaf);
        TreeNode Level1RightNode = new TreeNode(7);
        TreeNode root = new TreeNode(4, Level1LeftNode, Level1RightNode);
        System.out.println("My TreeNode: " + root);

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
