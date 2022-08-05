package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_15_3Sum {
    public static void main(String[] args) {
        Leetcode_15_3Sum l = new Leetcode_15_3Sum();
        System.out.println(l.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length < 3) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } // 去掉重复情况
            int l = i + 1, r = nums.length - 1, target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    ++l;
                    --r;
                    while (l < r && nums[l] == nums[l - 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        --r;
                    }
                } else if (nums[l] + nums[r] > target) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return ans;
    }
}

