package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_504_findRelativeRanks {

    public static void main(String[] args) {
        Leetcode_504_findRelativeRanks l = new Leetcode_504_findRelativeRanks();
        System.out.println(l.findRelativeRanks(new int[]{10, 3, 8, 9, 4}));
    }

    public String[] findRelativeRanks(int[] score) {
        int m = score.length;
        Integer[] ranks = new Integer[m];
        for (int i = 0; i < m; i++) {
            ranks[i] = i;
        }
        Arrays.sort(ranks, (i, j) -> {
            return score[j] - score[i];
        });

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            int cadidate = ranks[i];
            if (i == 0) {
                ans[cadidate] = "Gold Medal";
            } else if (i == 1) {
                ans[cadidate] = "Silver Medal";
            } else if (i == 2) {
                ans[cadidate] = "Bronze Medal";
            } else {
                ans[cadidate] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}