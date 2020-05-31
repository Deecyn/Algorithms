package leetcode;


import java.util.*;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) return false;
        if (s.isEmpty()) return true;

        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
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
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
