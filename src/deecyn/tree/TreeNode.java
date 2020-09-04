package deecyn.tree;

/**
 * @author Deecyn
 * @version 0.1
 * Description: 二叉树的结构定义
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
