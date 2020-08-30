package deecyn.tree;

import java.util.ArrayList;
/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 98.验证二叉搜索树
 */
public class LC098_ValidateBST {

    // 使用前一个节点的值 pre 代替链表存储
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
//        inorderTraversal(root);
//        return orderFlag;

        if (root == null) {
            return true;
        }

        // 遍历左子树
        if (!isValidBST(root.left)) {
            return false;
        }

        // 遍历根节点，并比较大小，判断有序性
        if (root.val < pre) {
            return false;
        }
        pre = root.val;

        // 遍历右子树
        return isValidBST(root.right);
    }


    ArrayList<TreeNode> list = new ArrayList<>();
    boolean orderFlag = true;
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        if (list.isEmpty() || list.get(list.size() - 1).val < root.val) {
            list.add(root);
        } else {
            orderFlag = false;
        }
        inorderTraversal(root.right);
    }

}
