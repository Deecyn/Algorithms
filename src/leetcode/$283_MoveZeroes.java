package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 慢指针，记录下一个非 0 元素应该在的位置。
        // 例如 slowIndex = 2 表示遍历到的下一个非 0 元素应该在数组的第 3 (2+1) 个位置上
        int slowIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            // 变量 i 作为快指针：
            // 如果第 i 个元素不等于 0，则交换快慢指针元素，然后快慢指针均递增 1 位
            // 否则，仅快指针 i 递增 1 位，慢指针 slowIndex 保持不动
            if (nums[i] != 0){
                nums[slowIndex] = nums[i];
                if (i != slowIndex){
                    nums[i] = 0;
                }
                slowIndex++;
            }
        }
    }
}
