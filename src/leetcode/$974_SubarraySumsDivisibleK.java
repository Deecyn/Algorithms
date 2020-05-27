package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deecyn
 * @version 0.14
 * Description: 前缀和 + 同余定理
 */
public class $974_SubarraySumsDivisibleK {
    /**
     * 通过 hash 表存储
     */
    public int byHashMap(int[] A, int K) {
        Map<Integer, Integer> recordMap = new HashMap<>(A.length);
        recordMap.put(0, 1);
        int sum = 0, result = 0;
        for (int num : A) {
            sum += num;
            int mod = (sum  % K + K) % K;
            int same = recordMap.getOrDefault(mod, 0);
            result += same;
            recordMap.put(mod, same + 1);
        }
        return result;
    }

    /**
     * 通过数组存储
     */
    public int byArray(int[] A, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int sum = 0, result = 0;
        for (int num : A) {
            sum += num;
            int mod = (sum  % K + K) % K;
            int same = count[mod]++;
            result += same;
        }
        return result;
    }
}
