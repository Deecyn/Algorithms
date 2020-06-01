package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $1431_KidsWithGreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }

        List<Boolean> results = new ArrayList<>(candies.length);
        for (int candy : candies) {
            results.add(candy + extraCandies >= max);
        }
        return results;
    }
}
