package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_216_combineSum {

    public static void main(String[] args) {
        Leetcode_216_combineSum l = new Leetcode_216_combineSum();
        System.out.println(l.combinationSum3(3, 7));
        System.out.println(l.combinationSum3(3, 9));
    }

    List<List<Integer>> ans;
    int target;
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        target = n;
        this.k = k;
        bfs(0, 0, k, new ArrayList<>());
        return ans;
    }

    public void bfs(int min, int sum, int remain, List<Integer> temp) {
        if (remain == 0 && sum == target) {
            ans.add(new ArrayList<>(temp));
        } else if (remain <= 0 || target - sum <= min) {
            return;
        }
        for (int next = min + 1; sum + next <= target && next <= 9; next++) {
            temp.add(next);
            bfs(next, sum + next, remain - 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}