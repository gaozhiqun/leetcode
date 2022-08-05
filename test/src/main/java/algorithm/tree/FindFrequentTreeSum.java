package algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午3:22
 */
public class FindFrequentTreeSum {
    public static void main(String[] args) {

    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        findFrequentTreeSum(root);
        int total = Integer.MIN_VALUE;
        int[] result = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (total < entry.getValue()) {
                total = entry.getValue();
                result = new int[]{entry.getKey(), entry.getValue()};
            }
        }
        return result;
    }

    private int sum(TreeNode cur, Map<Integer, Integer> countMap) {
        if (cur == null) {
            return 0;
        }
        int l = sum(cur.left, countMap);
        int r = sum(cur.left, countMap);
        int sum = l + r + cur.val;
        countMap.put(sum, countMap.getOrDefault(sum, 0));
        return sum;
    }
}
