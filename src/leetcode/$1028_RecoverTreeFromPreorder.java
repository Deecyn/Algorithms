package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $1028_RecoverTreeFromPreorder {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int idx = 0;
        char[] charsTree = S.toCharArray();
        while (idx < charsTree.length) {
            int depth = 0;
            while (charsTree[idx] == '-') {
                ++depth;
                ++idx;
            }

            int value = 0;
            while (idx < charsTree.length && Character.isDigit(charsTree[idx])) {
                value = value * 10 + (charsTree[idx] - '0');
                ++idx;
            }

            TreeNode node = new TreeNode(value);
            if (depth == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (depth != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }


    public TreeNode recoverFromPreorder2(String S) {
         char[] charsTree = S.toCharArray();

        for (int i = 0; i < charsTree.length; i++) {

            int countDash = 0;
            while (charsTree[i] == '-') {
                countDash++;
                i++;
            }


        }



         return null;
    }


}
