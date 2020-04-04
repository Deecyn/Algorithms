package leetcode;

import java.util.*;

/**bre
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $020_ValidParentheses {
    public boolean isValid(String s) {
        return byEnumerate(s);
    }

    /**
     * 使用数组，模拟栈来进行括号的匹配。
     *
     * 时间复杂度为 O(n)。实际效果很快，LeetCode 超过 100% 的用户。
     */
    public boolean byArraySwitch(String str){
        char[] chars = str.toCharArray();
        char[] parentheses = new char[chars.length];
        if (chars.length == 1) return false;

        // idx 表示将要存储「下一个括号」的位置索引
        int idx = 0;

        // 遇到左括号，则放入数组中；
        // 遇到右括号：若数组为空（idx = 0），表明括号不匹配，返回 false；
        //     若不为空，将数组尾端的元素（左括号）取出，与当前右括号相应的左括号进行比较；
        //     若相等，表明与上一个左括号互相匹配，进行下一轮比较。否则返回 false。
        for (char ch : chars) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    parentheses[idx++] = ch;
                    break;
                case ')':
                    if (idx == 0 || parentheses[--idx] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (idx == 0 || parentheses[--idx] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (idx == 0 || parentheses[--idx] != '}') {
                        return false;
                    }
                    break;
            }
        }
        // 不为空则表明：数组中还有未匹配的左括号
        return idx == 0;
    }

    /**
     * 仅通过栈的操作进行判断。
     *
     * 时间复杂度为 O(n)。实际效果较快，LeetCode 超过 98% 的用户。
     */
    public boolean byStack(String str){
        Stack<Character> stack = new Stack<>();

        // 遇到左括号，则将其相应的右括号入栈；
        // 遇到右括号，若与栈顶右括号相等，表明与上一个左括号互相匹配，进行下一轮比较；
        //    否则，表明与上一个左括号不匹配，返回 false。
        // 避免了使用第三方容器来存储和匹配括号。
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        // 不为空则表明：栈中还有未匹配的左括号
        return stack.isEmpty();
    }

    /**
     * 利用 HashMap 存储待匹配的括号；
     * 通过出栈、入栈操作进行匹配。
     *
     * 时间复杂度 O(n)。实际效果较快，LeetCode 超过 90% 的用户。
     */
    public boolean byStackHashMap(String str){
        Map<Character, Character> hashMap = new HashMap<Character, Character>(){
            {
                put('(', ')'); put('[', ']'); put('{', '}');
            }
        };
        Stack<Character> stack = new Stack<>();

        // 遇到左括号则入栈，遇到右括号则与栈顶括号相比较，看是否匹配
        for (char ch : str.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                stack.push(ch);
            }else if (stack.isEmpty() && !hashMap.containsKey(ch)){
                // 若当前栈为空，但字符为右括号，则返回 false
                return false;
            }else if (hashMap.get(stack.pop()) != ch){
                // 栈顶左括号出栈，若其相应的右括号与当前字符不相等，则返回 false；
                // 否则，进行下一轮比较
                return false;
            }
        }

        // 不为空则表明：栈中还有未匹配的左括号
        return stack.isEmpty();
    }

    /**
     * 利用 HashSet 存储待匹配的括号；
     * 通过出栈、入栈操作进行匹配。
     *
     * 时间复杂度为 O(n)。实际效果较慢，LeetCode 超过 50% 的用户。
     */
    public boolean byStackHashSet(String str){
        HashSet<Character> leftSet = new HashSet<>(Arrays.asList('(', '[', '{'));
        Stack<Character> stack = new Stack<>();

        // 遇到左括号则入栈，遇到右括号则与栈顶括号相比较，看是否匹配
        for (Character ch : str.toCharArray()) {
            if (leftSet.contains(ch)) {
                // 若为左括号，则入栈
                stack.push(ch);
            }else{
                if (stack.isEmpty() && !leftSet.contains(ch)) {
                    // 若当前栈为空，但字符为右括号，则返回 false
                    return false;
                }else if (matchParentheses(stack.peek(), ch)) {
                    // 若栈顶括号与当前括号匹配，则栈顶字符出栈
                    stack.pop();
                }else {
                    // 此时栈顶为左括号，当前字符为右括号，但两括号不匹配；返回false
                    return false;
                }
            }
        }
        // 不为空则表明：栈中还有未匹配的左括号
        return stack.isEmpty();
    }

    /**
     * 暴力枚举法：不断把匹配的括号替换成空字符串
     *
     * 错误，待完善，有 bug。。。。。
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
    private boolean matchParentheses(Character left, Character right){
        if (left.equals('(') && right.equals(')')){
            return true;
        } else if (left.equals('[') && right.equals(']')) {
            return true;
        } else {
            return left.equals('{') && right.equals('}');
        }
    }

    public static void main(String[] args) {
        System.out.println(new $020_ValidParentheses().byStackHashSet("]"));
    }
}
