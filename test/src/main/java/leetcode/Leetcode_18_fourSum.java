package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_18_fourSum {
    public static void main(String[] args) {
        Leetcode_18_fourSum l = new Leetcode_18_fourSum();
        //  System.out.println(l.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        //System.out.println(l.fourSum(new int[]{2, 2, 2, 2}, 8));
        System.out.println(l.fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(l.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }

    /**
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * a,b,c,d 互不相同
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int a = nums[i], b = nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int c = nums[l];
                    int d = nums[r];
                    if (a + b + c + d > target) {
                        r--;
                    } else if (a + b + c + d < target) {
                        l++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        temp.add(d);
                        ans.add(temp);
                        r--;
                        l++;
                        while (l < r && nums[r] == nums[r + 1]) {
                            --r;
                        }
                        while (l < r && nums[l] == nums[l - 1]) {
                            ++l;
                        }
                    }
                }
            }
        }
        return ans;
    }


}

