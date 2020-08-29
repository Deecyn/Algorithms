package deecyn.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 590.N叉树的后序遍历
 */
public class LC590_NtreePostorderTraversal {

    /**
     * N 叉树的结构定义
     */
    private class TreeNode {
        public int val;
        public List<TreeNode> children;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, List<TreeNode> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * N叉树后续遍历的 递归写法
     */
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorder(TreeNode root) {
        if (root != null){
            orderChildren(root.children);
            result.add(root.val);
        }
        return result;
    }

    public void orderChildren(List<TreeNode> children){
        for (TreeNode child : children) {
            orderChildren(child.children);
            result.add(child.val);
        }
    }
}


