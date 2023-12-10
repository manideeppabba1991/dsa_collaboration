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
        System.out.println("Breadth First Search Result: " + bfsResult);

    }

    private static List<Integer> breadthFirstSearchApproach(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while (queue.size() != 0) {
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
