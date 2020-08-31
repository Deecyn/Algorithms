package deecyn.tree;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC111_BinaryTreeMinDepth {

    /**
     * 给定一个二叉树，找出其最小深度，
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        // 1.如果左孩子和右孩子有为 null 的情况，直接返回 leftHeight + rightHeight + 1 ：
        //     1.1 如果左右孩子有一个为 null 时，返回不为空的孩子节点的深度，即此时 leftHeight 或者 rightHeight 为 0；
        //     1.2 如过左右孩子都为 null，那么返回 1，即 leftHeight 和 rightHeight 都为 0。
        // 2.如果都不为空，返回较小深度 + 1。
        return (root.left == null || root.right == null) ?
                leftHeight + rightHeight + 1 : Math.min(leftHeight, rightHeight) + 1;
    }
}
