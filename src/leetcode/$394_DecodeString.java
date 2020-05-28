package leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $394_DecodeString {
    int idx = 0;
    public String decodeString(String str) {
        LinkedList<String> stack = new LinkedList<>();

        while (idx < str.length()) {
            char ch = str.charAt(idx);

            if (Character.isDigit(ch)) {
                // 如果是数，则获取并进栈
                String digits = getDigits(str);
                stack.addLast(digits);
            } else if (Character.isLetter(ch) || ch == '[') {
                // 如果是字母或者左括号，则获取并进栈
                stack.addLast(String.valueOf(ch));
                ++idx;
            } else {
                // 如果是右括号：
                ++idx;

                LinkedList<String> sub = new LinkedList<>();
                // 从右括号开始，向前取出每个字符
                while (!"[".equals(stack.peekLast())){
                    sub.addLast(stack.removeLast());
                }
                // 反转，得到需要重复的子字符串队列
                Collections.reverse(sub);

                // 经过上面的 while 遍历后，栈顶的元素为左括号 '['
                stack.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repeatTimes = Integer.parseInt(stack.removeLast());

                // 将字符串队列转化为字符串，这就是需要重复的字符串
                String repeatStr = getString(sub);
                StringBuilder sb = new StringBuilder();
                while (0 < repeatTimes--) {
                    sb.append(repeatStr);
                }

                // 将构造好的字符串入栈
                stack.addLast(sb.toString());
            }
        }

        return getString(stack);
    }

    public String getDigits(String str) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(str.charAt(idx))) {
            sb.append(str.charAt(idx++));
        }
        return sb.toString();
    }

    public String getString(LinkedList<String> strList){
        StringBuilder sb = new StringBuilder();
        for (String s : strList) {
            sb.append(s);
        }
        return sb.toString();
    }


}
