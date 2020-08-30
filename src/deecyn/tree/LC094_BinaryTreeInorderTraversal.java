package deecyn.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 94.二叉树的中序遍历
 */
public class LC094_BinaryTreeInorderTraversal {

    /**
     * 二叉树的结构定义
     */
    private class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树中序遍历的递归写法
     */
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }

        return result;
    }

}


