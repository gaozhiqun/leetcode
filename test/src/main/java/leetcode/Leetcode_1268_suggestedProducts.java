package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/29 下午7:45
 */
public class Leetcode_1268_suggestedProducts {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeSet<String> treeSet = new TreeSet<>();
        List<List<String>> ret = new ArrayList<>();
        treeSet.addAll(Arrays.asList(products));
        for (int i = 0; i < searchWord.length(); ++i) {
            Set<String> removeSet = new HashSet<>();
            List<String> list = new ArrayList<>();
            for (String s : treeSet) {
                if (i >= s.length() || s.charAt(i) != searchWord.charAt(i)) {
                    removeSet.add(s);
                } else if (list.size() < 3) {
                    list.add(s);
                }
            }
            treeSet.removeAll(removeSet);
            ret.add(list);
        }
        return ret;

    }

    public int countServers(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    if (cur > 1) {
                        ret += cur;
                    }
                }
            }
        }
        return ret;
    }

    private int dfs(int[][] grid, int i, int j) {
        int ret = 1;
        grid[i][j] = 0;
        int m = grid.length, n = grid[0].length;
        for (int ix = 0; ix < m; ++ix) {
            if (grid[ix][j] == 1) {
                ret += dfs(grid, ix, j);
            }
        }
        for (int jx = 0; jx < n; ++jx) {
            if (grid[i][jx] == 1) {
                ret += dfs(grid, i, jx);
            }
        }
        return ret;
    }

    /**
     * @param nums
     * @return
     */
    public int maxSumDivThree2(int[] nums) {
        int min1a = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE,
                min2a = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (i % 3 == 1) {
                if (i < min1a) {
                    min1b = min1a;
                    min1a = i;
                } else if (i < min1b) {
                    min1b = i;
                }
            } else if (i % 3 == 2) {
                if (i < min2a) {
                    min2b = min2a;
                    min2a = i;
                } else if (i < min2b) {
                    min2b = i;
                }
            }
        }
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            if (min2a != Integer.MAX_VALUE && min2b != Integer.MAX_VALUE) {
                return sum - Math.min(min2a + min2b, min1a);
            } else {
                return sum - min1a;
            }
        } else {
            if (min1a != Integer.MAX_VALUE && min1b != Integer.MAX_VALUE) {
                return sum - Math.min(min1a + min1b, min2a);
            } else {
                return sum - min2a;
            }
        }
    }

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        int a, b, c;
        for (int i : nums) {
            a = dp[0] + i;
            b = dp[1] + i;
            c = dp[2] + i;
            dp[a % 3] = Math.max(dp[a % 3], a);
            dp[b % 3] = Math.max(dp[b % 3], b);
            dp[c % 3] = Math.max(dp[c % 3], c);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Leetcode_1268_suggestedProducts l = new Leetcode_1268_suggestedProducts();
        System.out.println(l.maxSumDivThree(new int[]{
                3, 6, 5, 1, 8
        }));
    }
}
