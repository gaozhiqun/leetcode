package algorithm.offer;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/9 8:48 下午
 */
public class PathSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        calculate(result, tempList, root, target);
        return result;
    }

    public void calculate(List<List<Integer>> result, List<Integer> temp, TreeNode cur, int target) {
        if (cur == null) {
            return;
        }
        helper(result, temp, cur, target);
        helper(result, temp, cur.left, target);
        helper(result, temp, cur.right, target);
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode cur, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (cur == null || cur.val < target) {
            return;
        }
        temp.add(cur.val);
        helper(result, temp, cur.left, target - cur.val);
        helper(result, temp, cur.right, target - cur.val);
        temp.remove(temp.size() - 1);
    }

    private int count = 0;

    public int pathSum3(TreeNode root, int targetSum) {
        find(root, targetSum);
        return count;
    }

    private void find(TreeNode cur, int target) {
        if (cur.val == target) {
            count++;
        }
        if (cur.left != null) {
            find(cur.left, target);
            find(cur.left, target - cur.val);
        }
        if (cur.right != null) {
            find(cur.right, target);
            find(cur.right, target - cur.val);
        }
    }

    public int pathSum4(TreeNode root, int target) {
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1);
        return recursiveSum(root, preSumCnt, target, 0);

    }

    public int recursiveSum(TreeNode cur, Map<Integer, Integer> preSumCnt, int target, int curSum) {
        if (cur == null) {
            return 0;
        }
        int result = 0;
        curSum += cur.val;
        result += preSumCnt.getOrDefault(curSum - target, -1);
        preSumCnt.put(curSum, preSumCnt.getOrDefault(curSum, 0) + 1);
        result += recursiveSum(cur.left, preSumCnt, target, curSum);
        result += recursiveSum(cur.right, preSumCnt, target, curSum);
        preSumCnt.put(curSum, preSumCnt.getOrDefault(curSum, 0) - 1);
        return result;
    }

}
