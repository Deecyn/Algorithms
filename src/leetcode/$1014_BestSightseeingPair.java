package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $1014_BestSightseeingPair {

    public static int maxScoreSightseeingPair(int[] A) {

        int maxScore = 0, frontMaxSum = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, frontMaxSum + A[j] - j);
            frontMaxSum = Math.max(frontMaxSum, A[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,9,10,5,9,10,4,5};
        System.out.println(maxScoreSightseeingPair(arr));
    }
}
