package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {

            while (!Character.isLetter(chars[i])) {
                ++i;
                if (i >= j) {
                    return false;
                }
            }
            char left = Character.toLowerCase(chars[i]);

            while (!Character.isLetter(chars[j])) {
                --j;
                if (i >= j) {
                    return false;
                }
            }
            char right = Character.toLowerCase(chars[j]);

            if (left != right) {
                return false;
            }
        }

        return true;
    }

}
