package deecyn.tree;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC104_BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
