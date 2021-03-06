package deecyn.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(0));
        results.remove(0);
        dfs(root, sum, new ArrayDeque<>(), results);
        return results;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.addLast(root.val);

        if (root.left == null && root.right == null && sum == 0){
            results.add(new ArrayList<>(path));
        }

        dfs(root.left, sum, path, results);
        dfs(root.right, sum, path, results);
        path.removeLast();
    }

}
