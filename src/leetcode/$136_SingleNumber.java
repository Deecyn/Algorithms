package leetcode;

import java.util.Arrays;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $136_SingleNumber {

    /**
     * 异或运算 ⊕ 有以下三个性质。
     *   1. 任何数和 0 做异或运算，结果仍然是原来的数，即 a ⊕ 0 = a 。
     *   2. 任何数和其自身做异或运算，结果是 0，即 a ⊕ a = 0。
     *   3. 异或运算满足交换律和结合律，即 a ⊕ b ⊕ a = b ⊕ a ⊕ a = b ⊕ (a ⊕ a) = b ⊕ 0 = b。
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
