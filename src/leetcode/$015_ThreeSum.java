package leetcode;

import java.util.*;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $015_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return byEnumerate(nums);
    }

    /**
     * 暴力枚举法，时间复杂度 O(n^3)，容易超时
     * 如何去重？先对内层 list 排序，然后采用 List 集合的 contains() 方法判断是否重复
     */
    public List<List<Integer>> byEnumerate(int[] nums){
        List<List<Integer>> results = new ArrayList<>(nums.length / 3);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);

                        if (!results.contains(list)){
                            results.add(list);
                        }
                    }
                }
            }
        }
        return results;
    }

    /**
     * 使用 hash 表优化暴力方法，
     * 理论时间复杂度 O(n^2)，未 AC，超时
     */
    public List<List<Integer>> funB(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer y = - nums[i] - nums[j]; // c = 0 - a -b

                if (hashMap.containsKey(y)){
                    Integer idx = hashMap.get(y);
                    if (idx != i && idx != j){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], y);
                        Collections.sort(list);

                        if (!results.contains(list)){
                            results.add(list);
                        }
                    }
                }
            }
        }

        return results;
    }

    /**
     * 优化的排序 + 双指针算法
     *
     * 参考链接：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     */
    public List<List<Integer>> byDoublePointerWithSort(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<>(num.length / 3);
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) break;

            // 根据 "||" 符号的特性，即：当 i > 0 且 num[i] == num[i - 1] 时，则跳过此元素 nums[i]；
            // 因为已经将 nums[i - 1] 的所有组合加入到结果集中，本次双指针搜索只会得到重复组合。
            if (i == 0 || num[i] != num[i - 1]) {

                int low = i + 1, high = num.length - 1, targetSum = 0 - num[i];
                while (low < high) {
                    if (num[low] + num[high] == targetSum) {
                        results.add(Arrays.asList(num[i], num[low], num[high]));

                        // 条件 low < high 应在 num[low] == num[low + 1] 之前判断，
                        // 否则在遍历到最后一个元素时，容易出现数组下标越界的问题
                        while (low < high && num[low] == num[++low]);
                        while (low < high && num[high] == num[--high]);
                    } else if (num[low] + num[high] < targetSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return results;
    }

}
