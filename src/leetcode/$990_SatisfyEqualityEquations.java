package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $990_SatisfyEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        int len = equations.length;

        // 定义长度为 26 的数组表示 26 个小写字母，记录每个字母的父节点。
        // 例如，索引 0 表示字母 a；parent[0] 的值为 3 则表示字母 a 的父节点为字母 d ('d' - 'a' = 3) 。
        int[] parent  = new int[26];

        // 初始化每个节点（字母）的父节点为它自身
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 遍历方程式数组，合并等式（'=='）的变量（字母）
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                // 找到等式左边的变量字母，用整型数字表示
                int left = str.charAt(0) - 'a';
                // 找到等式右边的变量字母，用整型数字表示
                int right = str.charAt(3) - 'a';
                unionRoot(parent, left, right);
            }
        }

        // 遍历方程式数组，判断不等式（'!='）的正确性
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int left = str.charAt(0) - 'a';
                int right = str.charAt(3) - 'a';
                if (findRoot(parent, left) == findRoot(parent, right)) {
                    // 如果根节点相等，说明它们在同一个连通分量上，返回不符合条件
                    return false;
                }
            }
        }

        return true;
    }

    /**  合并左右两个变量所在连通分量的根节点  */
    public void unionRoot(int[] parent, int left, int right) {
        parent[findRoot(parent, left)] = findRoot(parent, right);
    }

    /** 在连通分量上，从指定变量向上查找其根节点  */
    public int findRoot(int[] parent, int var) {

        // 向上查找其父节点，直到找到根节点
        while (parent[var] != var) {
            // 隔代压缩路径，降低时间复杂度
            parent[var] = parent[parent[var]];
            // 将 var 作为父节点变量，更新其信息
            var = parent[var];
        }

        // 返回根节点变量
        return var;
    }
}
