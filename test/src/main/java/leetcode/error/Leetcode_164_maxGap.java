package leetcode.error;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/12 上午11:39
 */
public class Leetcode_164_maxGap {
    public static void main(String[] args) {

    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int m = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (max - min) / (m - 1));
        int bucketSize = (max - min) / d + 1;
        int[][] buckets = new int[bucketSize][2];
        for (int[] bucket : buckets) {
            Arrays.fill(bucket, -1);
        }
        for (int i = 0; i < nums.length; ++i) {
            int n = (nums[i] - min) / d;
            if (buckets[n][0] == -1) {
                buckets[n][0] = buckets[n][1] = nums[i];
            } else {
                buckets[n][0] = Math.min(buckets[n][0], nums[i]);
                buckets[n][1] = Math.max(buckets[n][1], nums[i]);
            }
        }
        int prev = -1, ans = 0;
        for (int i = 0; i < bucketSize; ++i) {
            if (buckets[i][0] == -1) {
                continue;
            }
            if (prev > -1) {
                ans = Math.max(ans, buckets[i][0] - buckets[prev][1]);
            }
            prev = i;
        }
        return ans;
    }


}
