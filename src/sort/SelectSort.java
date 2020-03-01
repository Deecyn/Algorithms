package sort;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 选择排序 --蛮力法
 */
public class SelectSort {
    public static void main(String[] args) {
        // 测试：
//        int[] arr = {23,5,32,54,67,34,56,75,45};
        int[] arr = SortUtil.readFromFile("input_million.txt");

        long startMsTime = System.currentTimeMillis();
        long startNsTime = System.nanoTime();
        // 执行算法
        int[] sortArr = selectSort(arr);
        SortUtil.printSpendTime(startNsTime,startMsTime);

        SortUtil.printArray(sortArr);
    }

    /**
     * 用选择排序对给定的数组 arr 排序 --蛮力法
     * @param arr 一个可排序的数组
     * @return 升序排列的数组
     */
    public static int[] selectSort(int[] arr){
        // 记录当前扫描中最小元素的下标
        int minIndex = 0;
        for (int i = 0; i < arr.length-1; ++i) {
            // 每次扫描后，第 i 个位置的元素在第 i～n 部分的元素中总是最小的
            // 变量 i 用来表示数组前面有多少个确认位序的元素，i 之前的那些元素将不参与后面的比较
            minIndex = i;

            // 依次把第 i 个元素与它后面的元素作比较
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    // 当遇到更小的元素时，标记为最小元素的下标
                    minIndex = j;
                }
            }

            // 第 i 个元素与最小元素交换位置
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
