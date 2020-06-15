package leetcode;

import java.util.Arrays;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $1300_MutatedArrayFindBestValue {

    public int findBestValue_2(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;

        int[] prefixSum = new int[len + 1];
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int smaller = 0, larger = arr[len - 1], resultValue = -1;
        while (smaller < larger) {
            int middle = (smaller + larger) / 2;

            int closestMiddleIdx = Arrays.binarySearch(arr, middle);
            if (closestMiddleIdx < 0) {
                closestMiddleIdx = -closestMiddleIdx - 1;
            }

            int tmpSum = prefixSum[closestMiddleIdx] + middle * (len - closestMiddleIdx);
            if (tmpSum <= target) {
                resultValue = middle;
                smaller = middle + 1;
            } else {
                larger = middle - 1;
            }
        }

        int chooseSmall = getSum(arr, resultValue);
        int chooseBig = getSum(arr, resultValue + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? resultValue : resultValue + 1;
    }

    public int getSum(int[] arr, int x) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, x);
        }
        return sum;
    }



    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;

        int[] prefixSum = new int[len + 1];
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int resultValue = 0, minDiffer = target;
        for (int i = 0; i <= arr[len - 1]; i++) {
            int closestValueIndex = Arrays.binarySearch(arr, i);

            if (closestValueIndex < 0) {
                // 如果 Arrays.binarySearch(arr, i) 方法没有找到时返回 - (low + 1)
                closestValueIndex = - closestValueIndex - 1;
            }

            int tmpSum = prefixSum[closestValueIndex] + i * (len - closestValueIndex);
            if (Math.abs(tmpSum - target) < minDiffer) {
                resultValue = i;
                minDiffer = Math.abs(tmpSum - target);
            }
        }

        return resultValue;
    }

}
