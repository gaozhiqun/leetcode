package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_90_subsetsWithDup {

    /**
     * 输入：s1 = "great", s2 = "rgeat""abcdefghijklmnopq"
     * "efghijklmnopqcadb"
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_90_subsetsWithDup l = new Leetcode_90_subsetsWithDup();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(l.subsetsWithDup(nums));
        nums = new int[]{0};
        System.out.println(l.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, temp, -1, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int cur, int[] nums) {
        ans.add(new ArrayList<>(temp));
        for (int next = cur + 1; next < nums.length; ++next) {
            if (next > cur + 1 && nums[next] == nums[next - 1]) {
                continue;
            }
            temp.add(nums[next]);
            dfs(ans, temp, next, nums);
            temp.remove(temp.size() - 1);
        }
    }


}
