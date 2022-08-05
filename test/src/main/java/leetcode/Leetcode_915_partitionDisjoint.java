package leetcode;

import java.util.Arrays;


public class Leetcode_915_partitionDisjoint {
    public static void main(String[] args) {
        Leetcode_915_partitionDisjoint l = new Leetcode_915_partitionDisjoint();
        System.out.println(l.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(l.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(l.partitionDisjoint(new int[]{}));

    }

    public int partitionDisjoint(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int[] maxes = new int[N];
        maxes[0] = nums[0];
        for (int i = 1; i < N; ++i) {
            maxes[i] = Math.max(maxes[i - 1], nums[i]);
        }
        int[] mins = new int[N];
        mins[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            mins[i] = Math.min(mins[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            if (maxes[i] <= mins[i + 1]) {
                return i + 1;
            }
        }
        return N;
    }

}
