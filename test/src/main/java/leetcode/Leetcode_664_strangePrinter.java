package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_664_strangePrinter {

    public static void main(String[] args) {
        Leetcode_664_strangePrinter l = new Leetcode_664_strangePrinter();
        System.out.println(l.findKthNumber(3, 3, 5));
        System.out.println(l.constructArray(5, 4));
        System.out.println(l.constructArray(3, 2));
    }


    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minn;
                }
            }
        }
        return dp[0][n - 1];
    }


    public boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int l = 1, r = k + 1;
        for (int i = 0; i < n; ++i) {
            if (i <= k) {
                if (i % 2 == 0) {
                    ans[i] = l++;
                } else {
                    ans[i] = r--;
                }
            } else {
                ans[i] = i + 1;
            }
        }
        return ans;
    }

    private void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = getCount(m, n, mid);
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getCount(int m, int n, int x) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(x / i, n);
        }
        return cnt;
    }
}