package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/27 下午5:20
 */
public class Leetcode494 {
    public static void main(String[] args) {
        Leetcode494 l = new Leetcode494();
        System.out.println(l.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, 1);
        for (int i : nums) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dpMap.entrySet()) {
                int pre = entry.getKey();
                int cnt = entry.getValue();
                temp.put(pre + i, cnt + temp.getOrDefault(pre + i, 0));
                temp.put(pre - i, cnt + temp.getOrDefault(pre - i, 0));
            }
            dpMap = temp;
        }
        return dpMap.getOrDefault(target, 0);
    }
}
