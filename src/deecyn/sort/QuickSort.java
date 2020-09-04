package deecyn.sort;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/30 17:25.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {23,5,32,54,67,34,-3,-25,0,5,56,75,45};

        int[] arr = quickSort(a,0,a.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"、");
        }
    }

    /**
     * 快速排序
     * @param arr 待排序数组
     * @param startIdx 数组待排序的起始位置
     * @param endIdx 数组待排序的结尾位置
     * @return
     */
    public static int[] quickSort(int[] arr,int startIdx, int endIdx){
        // 设置从左边扫描的起点
        int leftIdx = startIdx;
        // 设置从右边扫描的起点
        int rightIdx = endIdx;
        // 设置支点：数组的中间元素
        int pivot = arr[(leftIdx + rightIdx) >> 1];

        // 左右两端分别进行扫描，只要两端没有交替，就一直扫描
        while (leftIdx <= rightIdx){

            // 从左端开始扫描，直到找到比支点大的数
            while (arr[leftIdx] < pivot ){
                leftIdx++;
            }

            // 从右端开始扫描，直到找到比支点小的数
            while (arr[rightIdx] > pivot){
                rightIdx--;
            }

            // 交换两数
            if (leftIdx <= rightIdx){
                int temp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = temp;

                // 跳过两数，继续扫描
                leftIdx++;
                rightIdx--;
            }
        }

        // 进行完上面的扫描后，保证了支点左边的数比支点小，支点右边的数比支点大；
        // 此时有：rightIdx < leftIdx；

        // 对当前支点左边的数再进行排序
        if (startIdx < rightIdx){
            quickSort(arr, startIdx, rightIdx);
        }

        // 对当前支点右边的数再进行排序
        if (leftIdx < endIdx){
            quickSort(arr, leftIdx, endIdx);
        }

        return arr;
    }
}
