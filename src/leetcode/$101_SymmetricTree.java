package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $101_SymmetricTree {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return checkByRecursion(root, root);
    }

    /**
     * 通过递归实现
     */
    private boolean checkByRecursion(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val && checkByRecursion(t1.left, t2.right)
                && checkByRecursion(t1.right, t2.left);
    }

    /**
     * 引入队列，将递归转化为迭代实现
     */
    private boolean checkByIteration(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(t1);
        nodeQueue.offer(t2);

        while (!nodeQueue.isEmpty()) {
            t1 = nodeQueue.poll();
            t2 = nodeQueue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }

            if (t1 == null || t2 == null || (t1.val != t2.val)) {
                return false;
            }

            nodeQueue.offer(t1.left);
            nodeQueue.offer(t2.right);

            nodeQueue.offer(t1.right);
            nodeQueue.offer(t2.left);
        }
        return true;
    }

}
