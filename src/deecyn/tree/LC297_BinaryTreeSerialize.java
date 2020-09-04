package deecyn.tree;

import java.util.*;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 297.二叉树的序列化与反序列化。
 */
public class LC297_BinaryTreeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("x,");
        } else {
            // 前序遍历
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(data.split(",")));
       return buildTree(linkedList);
    }

    private TreeNode buildTree(LinkedList<String> list) {
        String str = list.removeFirst();
        if (str.equals("x")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = buildTree(list);
        node.right = buildTree(list);
        return node;
    }


}
