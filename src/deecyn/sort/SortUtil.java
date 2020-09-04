package deecyn.sort;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/11/30 22:06.
 */
public class SortUtil {

    /**
     * 打印数组，30 个数一次换行
     * @param sortArr
     */
    public static void printArray(int[] sortArr){
        System.out.println("数组长度："+ sortArr.length);
        System.out.println("数组 sortArr 为：");
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i]+"、");
            if ((i+1) % 30 == 0){
                System.out.println();
            }
        }
    }


    /**
     * 打印算法花费的纳秒和毫秒时间
     * @param startNsTime 开始的纳秒时间
     * @param startMsTime 开始的毫秒时间
     */
    public static void printSpendTime(long startNsTime,long startMsTime){
        long endNsTime = System.nanoTime();
        long endMsTime = System.currentTimeMillis();
        System.out.println("算法运行纳秒时间：" + (endNsTime - startNsTime) + "ns");
        System.out.println("算法运行毫秒时间：" + (endMsTime - startMsTime) + "ms");
    }

    /**
     * 从文件读取一个 int 型数组
     */
    public static int[] readFromFile(String fileName){

        // 文件与类在一个路径下
        File file = new File(MergeSort.class.getResource(fileName).getFile());
        String inputStr = null;
        FileReader input = null;
        try {
            input = new FileReader(file);
            char[] chars = new char[1024000];
            int len = input.read(chars);
            inputStr = new String(chars,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 注意读取的字符串 inputStr 可能为空
        String[] chs = inputStr.split("\\s+");
        int[] arr = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            arr[i] = Integer.parseInt(chs[i]);
        }
        return arr;
    }
}
