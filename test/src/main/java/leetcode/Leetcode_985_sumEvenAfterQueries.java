package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_985_sumEvenAfterQueries {
    public static void main(String[] args) {
        Leetcode_985_sumEvenAfterQueries l = new Leetcode_985_sumEvenAfterQueries();
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int N = queries.length;
        int[] ret = new int[N];
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        for (int i = 0; i < queries.length; ++i) {
            int[] query = queries[i];
            int val = query[0], idx = query[1];
            if ((nums[idx] + val) % 2 == 0) {
                if (nums[idx] % 2 != 0) {
                    sum += nums[idx];
                }
                sum += val;
            } else {
                if (nums[idx] % 2 == 0) {
                    sum -= nums[idx];
                }
            }
            nums[idx] += val;
            ret[i] = sum;
        }
        return ret;
    }


    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }

    private String dfs(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            return sb.reverse().toString();
        }
        sb.append((char) ('a' + cur.val));
        String l = dfs(cur.left, sb);
        String r = dfs(cur.right, sb);
        sb.deleteCharAt(sb.length() - 1);
        return l.compareTo(r) > 0 ? r : l;
    }


}
