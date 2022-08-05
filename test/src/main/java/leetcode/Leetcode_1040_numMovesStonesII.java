package leetcode;

import com.sun.org.apache.bcel.internal.generic.FSTORE;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/7 下午3:00
 */
public class Leetcode_1040_numMovesStonesII {


    public static void main(String[] args) {

    }

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int N = stones.length;
        // s1 = stones[r]-stones[l]+1 -N
        //s2=min(stones[n−1]−stones[n−2]−1,stones[1]−stones[0]−1)。
        int max = stones[N - 1] - stones[0] + 1 - N;
        max -= Math.min(stones[N - 1] - stones[N - 2] - 1, stones[1] - stones[0] - 1);
        //move 0 or move n-1
        // n 大小连续的坐标内，初始时有最多的石子。
        int min = max;
        int i = 0;
        int j = 0;
        for (i = 0; i < N; ++i) {
            while (j + 1 < N && stones[j + 1] - stones[i] + 1 <= N) {
                ++j;
            }
            int cost = N - (j - i + 1);
            if (j - i + 1 == N - 1 && stones[j] - stones[i] + 1 == N - 1) {//special case
                cost = 2;
            }
            min = Math.min(min, cost);
        }
        return new int[]{min, max};
    }
}
