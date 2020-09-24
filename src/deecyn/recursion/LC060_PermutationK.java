package deecyn.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 60.第k个排列
 */
public class LC060_PermutationK {

    String resultStr = "";
    public String getPermutation(int n, int k) {
        backtrack(n, k, new int[n], new ArrayList<>(), new ArrayList<>(new ArrayList<>()));
        return resultStr;
    }

    private void backtrack(int n, int k, int[] visited, List<Integer> tempList, List<List<Integer>> resultList) {
        if (resultList.size() == k) {
            resultStr = listToString(resultList.get(resultList.size() - 1));
        }

        if (tempList.size() == n) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            tempList.add(i);
            backtrack(n, k, visited, tempList, resultList);
            visited[i] = 0;
            tempList.remove(tempList.size() - 1);
        }
    }

    private String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

}
