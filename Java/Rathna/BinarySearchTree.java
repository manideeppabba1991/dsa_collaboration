public class BinarySearchTree {
    public static void main(String[] args) {

        TreeNode bottomLeftleaf = new TreeNode(1);
        TreeNode bottomRightleaf = new TreeNode(3);
        TreeNode Level1LeftNode = new TreeNode(2, bottomLeftleaf, bottomRightleaf);
        TreeNode Level1RightNode = new TreeNode(7);
        TreeNode root = new TreeNode(4, Level1LeftNode, Level1RightNode);
        System.out.println(root);

        int searchElement = 2;
        TreeNode result = searchBST(root, searchElement);
        System.out.println("Result: " + result);

    }

    private static BinarySearchTree.TreeNode searchBST(BinarySearchTree.TreeNode root, int val) {
        // break/base conditions
        if (root == null) {
            return null;
        } else if (val == root.val) { // TC = O(log n) since we are using divide and conquer approach, SC = O(1)
            return root;
        }

        else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static class TreeNode {
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
}
