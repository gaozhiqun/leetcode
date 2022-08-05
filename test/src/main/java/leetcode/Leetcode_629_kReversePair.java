package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/7 下午4:15
 */
public class Leetcode_629_kReversePair {

    /**
     * 且恰好拥有 k 个逆序对的不同的数组的个数
     * dp[i][j] -> 前i个数字恰好有k个逆序对
     * dp[i][j] = dp[i-1][j-1]+  dp[i-1][j-2] +  dp[i-1][j-3]...
     * f[i][j]=f[i][j−1]−f[i−1][j−i]+f[i−1][j]
     *
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            int cur = i & 1, prev = cur ^ 1;
            for (int j = 0; j <= k; ++j) {
                dp[cur][j] = (j - 1 >= 0 ? dp[cur][j - 1] : 0) - (j - i >= 0 ? dp[prev][j - i] : 0) + dp[prev][j];
                if (dp[cur][j] >= MOD) {
                    dp[cur][j] -= MOD;
                } else if (dp[cur][j] < 0) {
                    dp[cur][j] += MOD;
                }
            }
        }
        return dp[n & 1][k];
    }

    private int countReversePair(int[] arrays) {
        ans = 0;
        mergeSort(arrays, 0, arrays.length - 1);
        return ans;
    }

    int ans;

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(l, mid, r, nums);
    }

    private void merge(int l, int mid, int r, int[] nums) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, idx = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[idx++] = nums[i++];
            } else {
                ans += (mid - i + 1);
                temp[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = nums[i++];
        }
        while (j <= r) {
            temp[idx++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, l, temp.length);
    }

}
