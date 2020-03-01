package sort;


/**
 * @author Deecyn
 * @version 1.0
 * Description: 合并排序 --分治法
 */
public class MergeSort {
    public static void main(String[] args) {
        // 测试：
//        int[] arr = {23,5,32,54,67,34,56,75,45};
        int[] arr = SortUtil.readFromFile("input_million.txt");
        int[] sortArr = arr;
        int[] tempArr = new int[sortArr.length];

        long startMsTime = System.currentTimeMillis();
        long startNsTime = System.nanoTime();
        // 执行算法
        mergeSort(sortArr,0,sortArr.length-1);
//        mergeSort(sortArr,0,sortArr.length-1,tempArr);
        SortUtil.printSpendTime(startNsTime,startMsTime);
        SortUtil.printArray(sortArr);
    }

    public static void mergeSort(int[] arr,int left,int right){
        // 中间位置索引
        int center = (left+right)/2;

        if (left < right){
            // 划分
            mergeSort(arr,left,center);
            mergeSort(arr,center+1,right);
             // 归并
            merge(arr,left,center,right);
//            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param tempArr 从开始就 new 好的临时数组
     */
    public static void mergeSort(int[] arr,int left,int right,int[] tempArr){
        // 中间位置索引
        int center = (left+right)/2;

        if (left < right){
            // 划分
            mergeSort(arr,left,center);
            mergeSort(arr,center+1,right);
            // 归并
            merge(arr,left,center,right,tempArr);
//            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 归并：
     *   在上一次的归并操作中，数组的左部分和右部分应该已经为有序序列；
     *   将待归并数组分为左数组和右数组两部分进行归并；
     * @param arr 待归并数组对象
     * @param left 左数组第一个元素的索引
     * @param center 左数组最后一个元素的索引，center+1 表示右数组第一个元素的索引
     * @param right 右数组最后一个元素的索引
     */
    public static void merge(int[] arr,int left,int center,int right){

        // 临时数组
        // 也可以从开始就申请一个与原数组大小相同的数组，因为重复 new 数组会频繁申请内存，消耗时间
         int[] tempArr = new int[arr.length];

        // 临时数组索引
        int tempIndex = left;

        // 左数组第一个元素索引
        int leftIndex = left;
        // 右数组第一个元素索引
        int rightIndex = center+1;

        // 要么左数组索引 leftIndex 递增直到左数组最后一个元素索引；
        // 要么右数组索引 rightIndex 递增直到右数组最后一个元素索引
        while (leftIndex <= center && rightIndex <= right){

            // 从两个数组中取出最小的元素放入临时数组
            // 因为两个数组已经为有序序列，所以当 arr[leftIndex] <= arr[rightIndex] 时，
            // arr[leftIndex] 一定小于 arr[rightIndex] 后面的每一个元素
            if (arr[leftIndex] <= arr[rightIndex]){
                tempArr[tempIndex++] = arr[leftIndex++];
            }else {
                tempArr[tempIndex++] = arr[rightIndex++];
            }
        }

        // 将剩余元素依次放入临时数组，实际上两个 while 只会执行其中一个
        while (leftIndex <= center){
            tempArr[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right){
            tempArr[tempIndex++] = arr[rightIndex++];
        }

        // 将临时数组中的元素拷贝回原数组
        // 原 left 至 right 范围的元素被复制回原数组
//        while (left <= right){
//            arr[left] = tempArr[left++];
//        }

        // 或者使用系统高效的数组拷贝方法：
        System.arraycopy(tempArr,left,arr,left,right-left+1);
    }


    /**
     * 归并：
     *   在上一次的归并操作中，数组的左部分和右部分应该已经为有序序列；
     *   将待归并数组分为左数组和右数组两部分进行归并；
     * @param arr 待归并数组对象
     * @param left 左数组第一个元素的索引
     * @param center 左数组最后一个元素的索引，center+1 表示右数组第一个元素的索引
     * @param right 右数组最后一个元素的索引
     * @param tempArr 也可以从开始就申请一个与原数组大小相同的数组，因为重复 new 数组会频繁申请内存，消耗时间
     */
    public static void merge(int[] arr,int left,int center,int right,int[] tempArr){

        // 临时数组 tempArr

        // 临时数组索引
        int tempIndex = left;

        // 左数组第一个元素索引
        int leftIndex = left;
        // 右数组第一个元素索引
        int rightIndex = center+1;

        // 要么左数组索引 leftIndex 递增直到左数组最后一个元素索引；
        // 要么右数组索引 rightIndex 递增直到右数组最后一个元素索引
        while (leftIndex <= center && rightIndex <= right){

            // 从两个数组中取出最小的元素放入临时数组
            // 因为两个数组已经为有序序列，所以当 arr[leftIndex] <= arr[rightIndex] 时，
            // arr[leftIndex] 一定小于 arr[rightIndex] 后面的每一个元素
            if (arr[leftIndex] <= arr[rightIndex]){
                tempArr[tempIndex++] = arr[leftIndex++];
            }else {
                tempArr[tempIndex++] = arr[rightIndex++];
            }
        }

        // 将剩余元素依次放入临时数组，实际上两个 while 只会执行其中一个
        while (leftIndex <= center){
            tempArr[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right){
            tempArr[tempIndex++] = arr[rightIndex++];
        }

        // 将临时数组中的元素拷贝回原数组
        // 原 left 至 right 范围的元素被复制回原数组
//        while (left <= right){
//            arr[left] = tempArr[left++];
//        }

        // 或者使用系统高效的数组拷贝方法：
        System.arraycopy(tempArr,left,arr,left,right-left+1);
    }


}








