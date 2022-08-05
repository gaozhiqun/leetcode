package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_435_pathSum {
    public static void main(String[] args) {
        Leetcode_435_pathSum l = new Leetcode_435_pathSum();

    }

    /**
     * 节点值之和等于 targetSum
     **/

    int ans, targetSum;
    Map<Long, Integer> cnts;


    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.ans = 0;
        this.cnts = new HashMap<>();
        cnts.put(0L, 1);
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode cur, long preSum) {
        if (cur == null) {
            return;
        }
        long curSum = preSum + cur.val;
        ans += cnts.getOrDefault(targetSum - curSum, 0);
        cnts.put(curSum, cnts.getOrDefault(curSum, 0) + 1);
        dfs(cur.left, curSum);
        dfs(cur.right, curSum);
        cnts.put(curSum, cnts.getOrDefault(curSum, 0) - 1);
    }

}
