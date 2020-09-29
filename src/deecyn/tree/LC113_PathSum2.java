package deecyn.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(0));
        results.remove(0);
        dfs(root, sum, new ArrayDeque<>(), results);
        return results;
    }

    /**  回溯 深度优先遍历 */
    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.addLast(root.val);

        // 符合要求的条件：当前为叶子节点，且路径总和等于目标和
        if (root.left == null && root.right == null && sum == 0){
            results.add(new ArrayList<>(path));
        }

        dfs(root.left, sum, path, results);
        dfs(root.right, sum, path, results);
        path.removeLast();
    }
}
