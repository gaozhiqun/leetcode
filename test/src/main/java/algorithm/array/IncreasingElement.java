package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 上午11:05
 */
public class IncreasingElement {

    public static void main(String[] args) {
        IncreasingElement increasingElement = new IncreasingElement();
        increasingElement.findSubsequences(new int[]{4, 6, 7, 7});
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int l = 0, r = 0, len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> seed = new ArrayList<>();
            seed.add(nums[i]);
            dfs(result, seed, i, nums);
        }
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> temp, int i, int[] nums) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] >= nums[i]) {
                temp.add(nums[j]);
                result.add(new ArrayList<>(temp));
                dfs(result, temp, j, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
