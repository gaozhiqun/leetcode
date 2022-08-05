package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_95_differentTrees {

    /**
     * 10
     */

    public static void main(String[] args) {
        Leetcode_95_differentTrees l = new Leetcode_95_differentTrees();
        System.out.println(l.numTrees(3));
        List<TreeNode> ans = l.generateTrees(3);
        System.out.println(ans.toString());
        ans = l.generateTrees(1);
        System.out.println(ans);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int l, int r) {
        if (l > r) {
            return null;
        }
        List<TreeNode> ans = new ArrayList<>();
        if (l == r) {
            ans.add(new TreeNode(l));
            return ans;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lChilds = buildTree(l, i - 1);
            List<TreeNode> rChilds = buildTree(i + 1, r);
            if (lChilds == null && rChilds == null) {
                ans.add(new TreeNode(i));
            } else if (rChilds == null) {
                for (TreeNode lchild : lChilds) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = lchild;
                    ans.add(newNode);
                }
            } else if (lChilds == null) {
                for (TreeNode rChild : rChilds) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.right = rChild;
                    ans.add(newNode);
                }
            } else {
                for (TreeNode lchild : lChilds) {
                    for (TreeNode rchild : rChilds) {
                        TreeNode newNode = new TreeNode(i);
                        newNode.left = deepCopy(lchild);
                        newNode.right = deepCopy(rchild);
                        ans.add(newNode);
                    }
                }
            }
        }
        return ans;
    }

    private TreeNode deepCopy(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = deepCopy(node.left);
        newNode.right = deepCopy(node.right);
        return newNode;
    }

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int cnts(int l, int r) {
        if (l >= r) {
            return 1;
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += cnts(l, i - 1) * cnts(i + 1, r);
        }
        return ans;
    }

}
