package deecyn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 94.二叉树的前序遍历
 */
public class LC144_BinaryTreePreorderTraversa {

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

    /**  递归写法 */
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    /**
     * 迭代写法 -- 基于栈实现
     */
    public List<Integer> iterator(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

}
