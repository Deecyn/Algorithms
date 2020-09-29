package deecyn.recursion;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>(n * n);
        backtrack(n, k, 1, new ArrayDeque<>(), results);
        return results;
    }

    public void backtrack(int n, int k, int start, Deque<Integer> path, List<List<Integer>> results){
        if (path.size() == k){
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {

            /* 进行剪枝：
             * i 表示每一轮搜索的起点，这个起点是有上界的，超过这个界限的起点则不会产生有效的答案，需要进行剪枝；
             * 例如 n=15，k=4，当 path.size()=2 时，起点的上界（最大值）就是 14，最后一个被选的是 [14, 15]，
             *   如果起点超过 14，可选的数字就不够 2 个了，path.size() 就不够 k 的值了，也就不会产生有效的结果了。
             *
             * 归纳可以得出：搜索起点的上界 + 接下来要选择的元素个数 - 1 = n，其中接下来要选择的元素个数等于 k - path.size()，
             * 即：搜索起点的上界 = n - (k - path.size()) + 1 。
             */
            if (i > (n - (k - path.size()) + 1)){
                break;
            }

            path.addLast(i);

            // 因为组合里面不允许出现重复的元素，所以下一轮搜索的起点要加 1；
            // 注意下一次的起点为 i + 1，而不是 start + 1，因为会有回溯的情况，i 不会恒等于 start。
            backtrack(n, k, i + 1, path, results);

            path.removeLast();
        }
    }

    @Test
    public void test1(){
        System.out.println(combine(4, 2));
    }


}
