package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_46_perMute {

    public static void main(String[] args) {
        Leetcode_46_perMute l = new Leetcode_46_perMute();
        System.out.println(l.permute(new int[]{1, 2, 3}));

    }

    /**
     * 互不相同的数字的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp, nums.length, nums, new boolean[nums.length]);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int todo,
                     int[] nums, boolean[] used) {
        if (todo == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(ans, temp, todo - 1, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
