package typical_problems;

import java.util.Scanner;

/**
 * @Author: Deecyn
 * @Date: Created in 21:04 2019/4/5
 * @Description: 控制台输入不确定长度的数组
 */
public class InputUncertainLengthArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] ch=str.split("\\s+");

        int[] arr=new int[ch.length];
        for(int i=0;i<ch.length;i++) {
            arr[i]=Integer.parseInt(ch[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"、");
        }
    }
}
