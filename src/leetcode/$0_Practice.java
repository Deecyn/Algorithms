package leetcode;


import java.math.BigInteger;
import java.util.*;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public void print(){

    }




    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>(nums.length / 3);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, twoSum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == twoSum) {
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[++low]);
                        while (low < high && nums[high] == nums[--high]);
                    } else if (nums[low] + nums[high] < twoSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return results;
    }


    public static String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int len = Math.max(lenA, lenB);
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int[] numsA = new int[len];
        int[] numsB = new int[len];

        for (int i = 0; i < lenA; i++) {
            numsA[len - lenA + i] = Integer.parseInt(String.valueOf(charsA[i]));
        }

        for (int i = 0; i < lenB; i++) {
            numsB[len - lenB + i] = Integer.parseInt(String.valueOf(charsB[i]));
        }

        BigInteger sum = new BigInteger("0");
        for (int i = len - 1; i >= 0; i--) {
            sum = sum.add(new BigInteger(String.valueOf((numsA[i] + numsB[i]) * Math.pow(2, len - 1 - i))));
        }

        return sum.toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
