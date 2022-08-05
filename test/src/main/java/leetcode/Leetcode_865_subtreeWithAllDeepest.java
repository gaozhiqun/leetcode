package leetcode;

import algorithm.tree.TreeNode;

import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_865_subtreeWithAllDeepest {
    public static void main(String[] args) {
        Leetcode_865_subtreeWithAllDeepest l = new Leetcode_865_subtreeWithAllDeepest();

    }

    TreeNode ret = null;
    int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return maxDepth(root).node;
    }

    private Result maxDepth(TreeNode cur) {
        if (cur == null) {
            return new Result(null, 0);
        }
        Result ld = maxDepth(cur.left);
        Result rd = maxDepth(cur.right);
        if (ld.dist > rd.dist) {
            return new Result(ld.node, ld.dist + 1);
        } else if (rd.dist > ld.dist) {
            return new Result(rd.node, rd.dist + 1);
        }
        return new Result(cur, ld.dist + 1);
    }

    public static class Result {
        public TreeNode node;
        public int dist;

        public Result(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}
