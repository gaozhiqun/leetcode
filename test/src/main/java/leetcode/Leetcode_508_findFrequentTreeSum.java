package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_508_findFrequentTreeSum {

    public static void main(String[] args) {
        Leetcode_508_findFrequentTreeSum l = new Leetcode_508_findFrequentTreeSum();
    }

    private Map<Integer, Integer> cntMap;
    int max;

    /**
     * 出现次数最多的子树元素和
     */

    public int[] findFrequentTreeSum(TreeNode root) {
        cntMap = new HashMap<>();
        max = 0;
        getSum(root);
        int max = Collections.max(cntMap.values());
        int n = 0;
        for (Integer key : cntMap.keySet()) {
            if (cntMap.get(key) == max) {
                n++;
            }
        }
        int[] ans = new int[n];
        n = 0;
        for (Integer key : cntMap.keySet()) {
            if (cntMap.get(key) == max) {
                ans[n++] = key;
            }
        }
        return ans;
    }

    private int getSum(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int m = cur.val + getSum(cur.left) + getSum(cur.right);
        Integer cnt = cntMap.computeIfAbsent(m, f -> 0);
        cntMap.put(m, cnt + 1);
        max = Math.max(max, cnt + 1);
        return m;
    }


}