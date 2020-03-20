package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $020_ValidParentheses {
    public boolean isValid(String s) {
        return byEnumerate(s);
    }

    /**
     * 暴力枚举法：不断把匹配的括号替换成空字符串
     *
     * 错误，待完善，充满 bug
     */
    public boolean byEnumerate(String str){
        Character[] chars = new Character[str.length()];

        // 将 String 转换成 Character 数组
        char[] s =  str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            chars[i] = s[i];
        }
        ArrayList<Character> leftList = new ArrayList<>(Arrays.asList('(', '[', '{'));

        int frontIdx = 0, backIdx = frontIdx + 1, emptyCount = 0;
        while (true){
            // 若当前字符是已经替换成空字符 ' '，则跳过当前字符
            while (chars[frontIdx].equals(' ')){
                frontIdx++;
                backIdx = frontIdx + 1;
            }
            while (chars[backIdx].equals(' ')){
                backIdx++;
            }

            // 若当前字符为左括号：
            if (leftList.contains(chars[frontIdx])) {

                if (leftList.contains(chars[backIdx])) {
                    // 若下一个字符也为左括号，则跳到下一个字符
                    frontIdx = backIdx;
                    backIdx++;
                } else if (matchParentheses(chars[frontIdx], chars[backIdx])) {
                    // 若当前字符与下一个字符成匹配的括号，则将这两个字符替换成 ' '，索引加 2
                    chars[frontIdx] = ' ';
                    chars[backIdx] = ' ';
                    frontIdx++;
                    backIdx = frontIdx + 1;
                    // 赋空计数加 2
                    emptyCount += 2;
                }else {
                    // 否则，
                    return false;
                }
            }else {
                return false;
            }

            if (frontIdx > chars.length - 2 && emptyCount < chars.length){
                frontIdx = 0;
                backIdx = 1;
            }else if (emptyCount == chars.length){
                return true;
            }
        }
    }

    /**
     * 判断两个字符是否是为互相匹配的括号
     */
    private boolean matchParentheses(Character x, Character y){
        if (x.equals('(') && y.equals(')')){
            return true;
        } else if (x.equals('[') && y.equals(']')) {
            return true;
        } else {
            return x.equals('{') && y.equals('}');
        }
    }

    public static void main(String[] args) {
        System.out.println(new $020_ValidParentheses().byEnumerate("{[]}"));
    }
}
