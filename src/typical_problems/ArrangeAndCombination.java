package typical_problems;

/**
 * @author: Deecyn
 * @Date: Created in 20:57 2019/4/5
 * @Description: 求排列组合数
 */
public class ArrangeAndCombination {
    public static void main(String[] args) {
        // 测试:
        int result = combination(6,2);
        System.out.println(result);
    }
    /**
     * 求排列数 A(n,m) n>=m
     */
    public static int arrange(int n, int m) {
        int result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;// 下一次减一
        }
        return result;
    }

    /**
     * 求组合数 C(n,m) n>=m
     *   应用组合数的互补率简化计算量
     */
    public static int combination(int n, int m){
        int half = n / 2;
        if (m > half) {
            m = n - m;
        }
        // 分子的排列数
        int numerator = arrange(n, m);
        // 分母的排列数
        int denominator = arrange(m, m);
        return numerator / denominator;
    }
}
