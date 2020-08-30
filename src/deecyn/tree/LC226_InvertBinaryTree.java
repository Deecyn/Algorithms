package deecyn.tree;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 226.翻转二叉树
 */
public class LC226_InvertBinaryTree {
    private class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**  递归写法 */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 应该交换左右字节点，而不是左右字节点的值
        root.left = right;
        root.right = left;
        return root;
    }

}
