package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $837_New_21_Game {
    public double new21Game(int N, int K, int W) {
        // 先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
        if (N - K + 1 >= W) {
            return 1.0;
        }

        // DP 数组，表示当前得分为 i 的时候，能赢的概率
        double[] probabilities = new double[K + W];
        // 将能赢得游戏的点数的概率设置为 1
        for (int i = K; i <= N; i++) {
            probabilities[i] = 1.0;
        }
        // 计算 K + W 这几个点数的概率和
        double afterSum = 1.0 * (N - K + 1);
        // 从 K - 1 开始计算，
        for (int i = K - 1; i >= 0; i--) {
            // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
            probabilities[i] = afterSum / W;
            afterSum = afterSum - probabilities[i + W] + probabilities[i];
        }

        return probabilities[0];
    }
}
