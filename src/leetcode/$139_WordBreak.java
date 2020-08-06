package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $139_WordBreak {

    public HashMap<String, Boolean> hash = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        //方便check，构建一个哈希表
        for(String word : wordDict){
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for(int j = 1; j <= s.length(); j++){
            for(int i = j-1; i >= 0; i--){
                dp[j] = dp[i] && check(s.substring(i, j));
                if(dp[j])   break;
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s){
        return hash.getOrDefault(s, false);
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        int minLength = Integer.MAX_VALUE;
        for (String word : wordDict) {
            minLength = Math.min(minLength, word.length());
        }

        StringBuilder strBuilder = new StringBuilder(s);
        while (strBuilder.length() >= minLength){
            boolean containsFlag = false;
            for (String word : wordDict) {
                int idx = -1;
                if ((idx = strBuilder.indexOf(word)) >= 0){
                    containsFlag = true;
                    strBuilder.delete(idx, idx + word.length());
                    break;
                }
            }
            // 如果遍历了一遍词典，字符串中没有包含词典中的任何 word，则返回 false
            if (!containsFlag){
                return false;
            }
        }

        return strBuilder.length() == 0;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");

    }
}
