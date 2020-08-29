package deecyn.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC022_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
//        return byRecursion(0, 0, n, "", new ArrayList<String>(n));
        return dfs(n, n, "", new ArrayList<>(n));
    }

    /**  自底向上的递归 */
    public List<String> byRecursion(int countLeft, int countRight, int n, String str, List<String> strList) {
        if (countLeft == n && countRight == n) {
            strList.add(str);
            return strList;
        }

        if (countLeft < n) {
            strList = byRecursion(countLeft + 1, countRight, n, str + "(", strList);
        }
        if (countRight < countLeft) {
            strList = byRecursion(countLeft, countRight + 1, n, str + ")", strList);
        }

        return strList;
    }

    /**  自顶向下的递归 */
    public List<String> dfs(int lastLeft, int lastRight, String str, List<String> strList) {
        if (lastLeft == 0 && lastRight == 0) {
            strList.add(str);
            return strList;
        }

        if (lastLeft > 0) {
            strList = dfs(lastLeft - 1, lastRight, str + "(", strList);
        }
        if (lastRight > lastLeft) {
            strList = dfs(lastLeft, lastRight - 1, str + ")", strList);
        }

        return strList;
    }
}
