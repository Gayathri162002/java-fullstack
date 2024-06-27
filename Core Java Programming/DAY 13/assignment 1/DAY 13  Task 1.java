DAY 13 
java code:
ackage packageBinaryTree;

public class TreeNode {
	 int val;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int x) {
	        val = x;
	    }
	}
ackage packageBinaryTree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        return checkBalanceAndHeight(root).balanced;
    }

    private BalanceStatusWithHeight checkBalanceAndHeight(TreeNode node) {
        if (node == null) {
            return new BalanceStatusWithHeight(true, 0);
        }

        BalanceStatusWithHeight leftResult = checkBalanceAndHeight(node.left);
        if (!leftResult.balanced) {
            return new BalanceStatusWithHeight(false, 0);
        }

        BalanceStatusWithHeight rightResult = checkBalanceAndHeight(node.right);
        if (!rightResult.balanced) {
            return new BalanceStatusWithHeight(false, 0);
        }

        boolean balanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new BalanceStatusWithHeight(balanced, height);
    }

    private static class BalanceStatusWithHeight {
        boolean balanced;
        int height;

        BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing a simple balanced binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BalancedBinaryTree treeChecker = new BalancedBinaryTree();
        System.out.println(treeChecker.isBalanced(root));  // Output: true
    }
}

