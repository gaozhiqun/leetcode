package leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_577_findUnsortedSubarray {


    public static void main(String[] args) {
        Leetcode_577_findUnsortedSubarray leetcode_560_subarraySum = new Leetcode_577_findUnsortedSubarray();
        System.out.println(leetcode_560_subarraySum.minDistance("sea", "eat"));
        System.out.println(leetcode_560_subarraySum.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(leetcode_560_subarraySum.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(leetcode_560_subarraySum.findUnsortedSubarray(new int[]{0}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int m = nums.length;
        Integer[] arr = new Integer[m];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            return nums[a] - nums[b];
        });
        int l = nums.length - 1, r = 0;
        for (int j = 0; j < nums.length; j++) {
            int i = arr[j];
            if (i == j) {
                continue;
            } else {
                l = Math.min(l, Math.min(i, j));
                r = Math.max(r, Math.max(i, j));
            }
        }
        if (l < r) {
            return r - l + 1;
        }
        return 0;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    /**
     * 删除任意一个字符串中的一个字符。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }


}