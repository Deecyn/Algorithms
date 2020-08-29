package deecyn.tree.structure;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
