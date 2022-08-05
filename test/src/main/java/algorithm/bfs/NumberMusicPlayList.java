package algorithm.bfs;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午8:19
 */
public class NumberMusicPlayList {
    public static void main(String[] args) {

    }

    /**
     * 每首歌至少播放一次！
     * dp[L+1][N+1];
     * dp[0][0] = 1;
     * dp[i][j] +=dp[i-1][j-1] * (N-(j-1))// a new song
     * dp[i][j] +=dp[i-1][j] * Math.max(0, i-k)//最近K首歌，一定不重复
     *
     * @param N
     * @param L
     * @param k
     * @return
     */
    public int numMusicPlayList(int N, int L, int k) {
        if (N <= k) {
            return 0;
        }
        int mod = 100_000_007;
        int[][] dp = new int[L + 1][N + 1];//播放了i首歌，包括j首不同的歌的数量
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i) {
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);
                dp[i][j] += dp[i - 1][j] * Math.max(j - k, 0);
                dp[i][j] %= mod;
            }
        }
        return dp[L][N];
    }
}
