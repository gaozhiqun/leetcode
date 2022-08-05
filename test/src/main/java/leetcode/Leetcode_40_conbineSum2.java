package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_40_conbineSum2 {

    public static void main(String[] args) {
        Leetcode_40_conbineSum2 l = new Leetcode_40_conbineSum2();
        // System.out.println(l.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(l.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] cnts = new int[51];
        for (int i : candidates) {
            cnts[i]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, 1, target, cnts, ans, temp);
        return ans;
    }

    private void dfs(int sum, int s, int target, int[] cnts, List<List<Integer>> ans, List<Integer> temp) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = s; i <= target - sum; i++) {
            if (cnts[i] > 0) {
                cnts[i]--;
                temp.add((i));
                dfs(sum + i, i, target, cnts, ans, temp);
                temp.remove(temp.size() - 1);
                cnts[i]++;
            }
        }
    }

}
