package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_47_perMuteII {

    public static void main(String[] args) {
        Leetcode_47_perMuteII l = new Leetcode_47_perMuteII();
        System.out.println(l.permuteUnique(new int[]{1, 2, 3}));
        System.out.println(l.permuteUnique(new int[]{1, 1, 2}));

    }

    /**
     * 互不相同的数字的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i : nums) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        dfs(ans, temp, cnts, nums.length);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, Map<Integer, Integer> cnts, int todo) {
        if (todo == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i : cnts.keySet()) {
            int remain = cnts.get(i);
            if (remain > 0) {
                temp.add(i);
                cnts.put(i, remain - 1);
                dfs(ans, temp, cnts, todo - 1);
                cnts.put(i, remain);
                temp.remove(temp.size() - 1);
            }
        }
    }


}
