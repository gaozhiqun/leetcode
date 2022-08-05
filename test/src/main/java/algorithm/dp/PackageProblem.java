package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/11 下午6:06
 */
public class PackageProblem {
    public static void main(String[] args) {

    }

    /**
     * 0/1背包问题 每个物品只有一件
     */
    public int zeroPack(int[] stones, int[] costs, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = k; j >= costs[i]; --j) {
                dp[k] = Math.max(dp[k], dp[k - costs[i]] + stones[i]);
            }
        }
        return dp[k];
    }

    /**
     * 完全背包问题
     * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是w[i]，价值是v[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */

    public int fullZeroPack(int[] stones, int[] costs, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            int v = stones[i], c = costs[i];
            for (int j = c; j <= k; ++j) {
                dp[j] = Math.max(dp[j], dp[j - c] + v);
            }
        }
        return dp[k];
    }

    /**
     * 多重背包问题 - 从完全背包发展而来，完全背包只是取一件，这里可以有多重策略
     * 有N种物品和一个容量为V的背包。
     * 第i种物品最多有n[i]件可用，
     * 每件费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */

    public int multiZeroPack(int[] stones, int[] costs, int[] cnts, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            int v = stones[i], c = costs[i], n = cnts[i];
            for (int j = k; j >= c; --j) {
                for (int m = 0; m <= n && m * c <= k; ++m) {
                    dp[k] = Math.max(dp[k], dp[k - costs[i - m * c]] + m * v);
                }
            }
        }
        return dp[k];
    }


    /**
     * 混合背包问题
     * 有的物品只可以取一次（01背包），有的物品可以取无限次（完全背包），有的物品可以取的次数有一个上限
     */

    /**
     * 二维背包问题的理解
     * 对于每件物品，具有两种不同的费用；选择这件物品必须同时付出这两种代价；
     * 对于每种代价都有一个可付出的最大值（背包容量）。
     * 问怎样选择物品可以得到最大的价值。设这两种代价分别为代价1和代价2，
     * 第i件物品所需的两种代价分别为a[i]和b[i]。两种代价可付出的最大值（两种背包容量）分别为V和U。物品的价值为w[i]。
     */

    public int twoDimensionPack(int W, int V, int[] weights, int[] volumes, int[] values) {
        int n = weights.length;//选择个数
        int[][] dp = new int[W + 1][V + 1];
        for (int k = 0; k < n; k++) {
            int c1 = weights[k], c2 = volumes[k], v = values[k];
            for (int i = W; i >= c1; ++i) {
                for (int j = V; j >= c2; ++j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - c1][j - c2] + v);
                }
            }
        }
        return dp[W][V];
    }

    /**
     * 分组背包
     * 有N件物品和一个容量为V的背包。
     * 第i件物品的费用是c[i]，价值是w[i]。
     * 这些物品被划分为若干组，每组中的物品互相冲突，最多选一件。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */
    public int partitionBag(int[][] costs, int[][] values, int N, int V, int k) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < k; ++i) {//分组
            for (int v = V; v > 0; v--) { // 容量
                for (int s = 0; s < costs[i].length; s++) {
                    dp[v] = Math.max(dp[v], dp[v - costs[i][s]] + values[i][s]);
                }
            }
        }
        return dp[V];
    }

    /**
     *有依赖的背包问题
     */



}
