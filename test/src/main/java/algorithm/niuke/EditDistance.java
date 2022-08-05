package algorithm.niuke;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/17 下午10:47
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        editDistance.rotateMatrix(mat, 3);
        System.out.println(editDistance.generateParenthesis(3));
        System.out.println(editDistance.minNumberDisappeared(new int[]{7, 8, 9, 11, 12}));
        System.out.println(editDistance.minNumberDisappeared(new int[]{1, 2, 3}));
        System.out.println(editDistance.minNumberDisappeared(new int[]{-2, 3, 4, 1, 5}));
        System.out.println(editDistance.minEditCost("abc", "adc", 5, 3, 2));
        System.out.println(editDistance.minEditCost("abc", "adc", 5, 3, 100));
    }

    /**
     * @param str1
     * @param str2
     * @param ic   插入
     * @param dc   删除
     * @param rc   替换
     * @return
     */
    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = i * dc;
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = j * ic;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc,
                            Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
                }
            }
        }
        return dp[m][n];
    }


    int ret;

    public int sumNumbers(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        ret = 0;
        dfs(root, 0);
        return ret;
    }

    private void dfs(TreeNode cur, int acc) {
        acc = acc * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            ret += acc;
            return;
        }
        if (cur.left != null) {
            dfs(cur.left, acc);
        }
        if (cur.right != null) {
            dfs(cur.right, acc);
        }
    }

    ArrayList<ArrayList<Integer>> list;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        if (root == null) {
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfsSum(root, 0, expectNumber, temp);
        return list;
    }

    private void dfsSum(TreeNode cur, int acc, int target, List<Integer> temp) {
        acc += cur.val;
        temp.add(cur.val);
        if (cur.left == null && cur.right == null && acc == target) {
            list.add(new ArrayList<>(temp));
        }
        if (cur.left != null) {
            dfsSum(cur.left, acc, target, temp);
        }
        if (cur.right != null) {
            dfsSum(cur.right, acc, target, temp);
        }
        temp.remove(temp.size() - 1);
    }


    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int i = 0, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (mat[i][j] == x) {
                return new int[]{i, j};
            } else if (mat[i][j] < x) {
                ++i;
            } else {
                --j;
            }
        }
        return null;
    }

    public int minNumberDisappeared(int[] nums) {
        // write code here
        int m = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < m; ++i) {
            int cur = nums[i];
            while (cur >= 0 && cur < m && cur != nums[cur]) {
                int next = nums[cur];
                nums[cur] = cur;
                cur = next;
            }
            if (nums[i] != i) {
                nums[i] = cur;
            }
        }
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        return max == m ? m + 1 : m;
    }

    int max;

    public int maxPathSum(TreeNode root) {
        // write code here
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));
        max = Math.max(max, l + r + root.val);
        return root.val + Math.max(l, r);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l != null && r != null) {
            if (l.val != r.val) {
                return false;
            }
            return isSymmetrical(l.left, r.right) && isSymmetrical(r.left, l.right);
        }
        return false;
    }

    Set<String> retSet;

    public ArrayList<String> generateParenthesis(int n) {
        retSet = new HashSet<>();
        dfs(new StringBuilder(), n, 0, 0);
        return new ArrayList<>(retSet);
    }

    private void dfs(StringBuilder sb, int n, int i, int j) {
        if (i == n && j == n) {
            retSet.add(sb.toString());
        }
        if (i < n) {
            sb.append('(');
            dfs(sb, n, i + 1, j);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (j < i) {
            sb.append(')');
            dfs(sb, n, i, j + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int l = 0, r = n - 1, up = 0, bot = n - 1;
        while (l < r) {
            for (int offset = 0; offset < r - l; ++offset) {
                int temp = mat[up][l + offset];
                mat[up][l + offset] = mat[bot - offset][l];
                mat[bot - offset][l] = mat[bot][r - offset];
                mat[bot][r - offset] = mat[up + offset][r];
                mat[up + offset][r] = temp;
            }
            ++l;
            --r;
            ++up;
            --bot;
        }
        return mat;
    }

    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }


}
