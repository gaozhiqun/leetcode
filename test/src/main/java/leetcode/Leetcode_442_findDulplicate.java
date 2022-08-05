package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_442_findDulplicate {
    public static void main(String[] args) {
        Leetcode_442_findDulplicate l = new Leetcode_442_findDulplicate();
        System.out.println(l.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }


    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == (i + 1)) {
                continue;
            }
            while (nums[i] != (i + 1)) {
                int j = nums[i] - 1;
                if (nums[j] == (j + 1)) {
                    ans.add(nums[j]);
                    break;
                }
                swap(i, j, nums);
            }
        }
        return new ArrayList<>(ans);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
