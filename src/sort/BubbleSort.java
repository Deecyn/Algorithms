package sort;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 冒泡排序 --蛮力法
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 测试：
//        int[] arr = {23,5,32,54,67,34,56,75,45};
        int[] arr = SortUtil.readFromFile("input_million.txt");

        long startMsTime = System.currentTimeMillis();
        long startNsTime = System.nanoTime();

        int[] sortArr = bubbleSort(arr);

        SortUtil.printSpendTime(startNsTime,startMsTime);
        SortUtil.printArray(sortArr);
    }

    /**
     * 用冒泡排序对给定的数组 arr 排序 --蛮力法
     * @param arr 一个可排序的数组
     * @return 升序排列的数组
     */
   public static int[] bubbleSort(int[] arr){

       for (int i = 0; i < arr.length - 1; i++) {
           // 每循环一轮，数组的末尾就会放置一个确定位序的元素，
           // i 用来表示数组末尾有多少个确认位序的元素，那些元素将不参与后面的比较
           for (int j = 0; j < arr.length - 1 - i; j++) {
               // 每个元素与其相邻元素比较，将较大的元素依次后移
               if (arr[j] > arr[j + 1]){
                   // 相邻元素交换位置
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
       }
        return arr;
   }
}
