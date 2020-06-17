package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            boolean isPublic = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    isPublic = false;
                    break;
                }
            }

            if (isPublic) {
                stringBuilder.append(ch);
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }

}
