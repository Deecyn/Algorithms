package deecyn.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 257. 二叉树的所有路径
 */
public class LC257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, new StringBuilder(), paths);
        return paths;
    }

    public void constructPaths(TreeNode root, StringBuilder path, List<String> paths) {
        if (root == null) {
            return;
        }

        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(root.val);
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(pathSB.toString());  // 把路径加入到答案中
            return;
        }

        pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
        constructPaths(root.left, pathSB, paths);
        constructPaths(root.right, pathSB, paths);
    }

}
