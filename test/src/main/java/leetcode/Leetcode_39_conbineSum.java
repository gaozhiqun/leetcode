package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_39_conbineSum {

    public static void main(String[] args) {
        Leetcode_39_conbineSum l = new Leetcode_39_conbineSum();
        System.out.println(l.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, 0, ans, temp, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int k, List<List<Integer>> ans, List<Integer> temp, int cur, int target) {
        if (cur == target) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = k; i < candidates.length; ++i) {
            if (cur + candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(candidates, i, ans, temp, cur + candidates[i], target);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
