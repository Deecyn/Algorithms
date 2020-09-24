package test;

import java.util.Scanner;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input == null || input.length() < 4) return;

        int count = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))){
                temp.append(input.charAt(i));
                count++;
            } else if (count == 4){
                int num = Integer.parseInt(temp.toString());
                if (num >= 1000 && num <= 3999){
                    resultStr.append(temp);
                }
                temp = new StringBuilder();
                count = 0;
            } else {
                temp = new StringBuilder();
                count = 0;
            }
        }

        String result = resultStr.toString();
        if (result.length() < 4) return;

        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i));
            if ((i + 1) % 4 == 0 && (i + 1) < result.length()){
                System.out.print(" ");
            }
        }
    }

}
