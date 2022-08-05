package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_14_3Sum {
    public static void main(String[] args) {
        Leetcode_14_3Sum l = new Leetcode_14_3Sum();
        System.out.println(l.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
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

