package sort;

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
     * @param start 数组待排序的起始位置
     * @param end 数组待排序的结尾位置
     * @return
     */
    public static int[] quickSort(int[] arr,int start, int end){
        // 设置从左边扫描的起点
        int left = start;
        // 设置从右边扫描的起点
        int right = end;
        // 设置支点：数组的中间元素
        int pivot = arr[(left + right) / 2];

        // 左右两端分别进行扫描，只要两端没有交替，就一直扫描
        while (left <= right){

            // 从左端开始扫描，直到找到比支点大的数
            while (arr[left] < pivot ){
                left++;
            }

            // 从右端开始扫描，直到找到比支点小的数
            while (arr[right] > pivot){
                right--;
            }

            // 交换两数
            if (left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // 跳过两数，继续扫描
                left++;
                right--;
            }
        }

        // 进行完上面的扫描后，保证了支点左边的数比支点小，支点右边的数比支点大；
        // 此时有：right < left；

        // 对当前支点左边的数再进行排序
        if (start < right){
            quickSort(arr,start,right);
        }

        // 对当前支点右边的数再进行排序
        if (left < end){
            quickSort(arr,left,end);
        }

        return arr;
    }
}
