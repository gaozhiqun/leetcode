package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Leetcode_920_numMusicPlaylists {
    public static void main(String[] args) {
        Leetcode_920_numMusicPlaylists l = new Leetcode_920_numMusicPlaylists();
        System.out.println(l.numMusicPlaylists(3, 3, 1));
        System.out.println(l.numMusicPlaylists(2, 3, 0));
        System.out.println(l.numMusicPlaylists(2, 3, 1));
    }

    public int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[L + 1][N + 1];
        int MOD = 1_000_000_007;
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i) {
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);//新歌
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[L][N];
    }



}
