package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class Convert36To10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input == null || input.length() == 0) {
            System.out.println(0);
            return;
        }
        String str36 = input.charAt(0) == '-' ? input.substring(1) : input;


        String x36 = "0123456789abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> _36ToTenMap = new HashMap<>();
        for (int i = 0; i < x36.length(); i++) {
            _36ToTenMap.put(x36.charAt(i), i);
        }

        long decimal = 0;
        int power = str36.length() - 1;
        char[] keys = str36.toCharArray();
        for (int i = 0; i < str36.length(); i++) {
            if (!_36ToTenMap.containsKey(keys[i])){
                decimal = 0;
                break;
            }


            int value = _36ToTenMap.get(keys[i]);
            long newDecimal = (long) (decimal + value * Math.pow(36, power));
            if (decimal > Long.MAX_VALUE / 2 && newDecimal < decimal){
                decimal = Long.MAX_VALUE;
                break;
            }
            decimal = newDecimal;

            power--;
        }
        System.out.println(decimal);
    }
}
