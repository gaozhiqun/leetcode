package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_77_combine {

    public static void main(String[] args) {
        Leetcode_77_combine l = new Leetcode_77_combine();
        System.out.println(l.combine(4, 2));
        System.out.println(l.combine(1, 1));
        System.out.println(l.subSet(new int[]{1,2,3}));
        System.out.println(l.subSet(new int[]{0}));


    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return new ArrayList<>();
        }
        boolean[] used = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(temp, ans, k, 0, used);
        return ans;
    }

    private void dfs(List<Integer> temp, List<List<Integer>> ans, int todo, int l, boolean[] used) {
        if (todo == 0) {
            ans.add(new ArrayList<>(temp));
        }
        if (todo > used.length - l) {
            return;
        }
        for (int i = l; i < used.length; i++) {
            if (!used[i]) {
                temp.add(i + 1);
                used[i] = true;
                dfs(temp, ans, todo - 1, i + 1, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> subSet(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs2(nums, temp, ans, 0, used);
        return ans;
    }

    private void dfs2(int[] nums, List<Integer> temp, List<List<Integer>> ans, int l, boolean[] used) {
        ans.add(new ArrayList<>(temp));
        for (int i = l; i < used.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs2(nums, temp, ans, i + 1, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


}
