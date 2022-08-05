package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/1 下午3:41
 */
public class Leetcode_1478_minDistance {


    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int l = 0, ret = 0;
        for (int i = 0; i < nums.length; ++i) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                int c = treeMap.get(nums[l]);
                if (c == 1) {
                    treeMap.remove(nums[l]);
                } else {
                    treeMap.put(nums[l], c - 1);
                }
                ++l;
            }
            ret = Math.max(ret, i - l + 1);
        }
        return ret;
    }


    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
        int len = nums.size();
        int m = nums.size();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.size(); ++i) {
            m = Math.max(m, i + nums.get(i).size());
        }
        for (int i = 0; i < len; ++i) {
            dfs1(i, 0, nums, ret);
        }
        for (int i = len - 1, j = 1; (i + j) < m; ++j) {
            dfs1(i, j, nums, ret);
        }
        int idx = 0;
        int[] res = new int[ret.size()];
        for (int i : ret) {
            res[idx++] = i;
        }
        return res;
    }

    private void dfs1(int i, int j, List<List<Integer>> nums, List<Integer> ret) {
        if (i < 0) {
            return;
        }
        if (j < nums.get(i).size()) {
            ret.add(nums.get(i).get(j));
        }
        System.out.println(ret);
        dfs1(i - 1, j + 1, nums, ret);
    }


    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<int[]>();
        int rows = nums.size();
        for (int i = 0; i < rows; i++) {
            List<Integer> rowList = nums.get(i);
            int cols = rowList.size();
            for (int j = 0; j < cols; j++) {
                int num = rowList.get(j);
                list.add(new int[]{i + j, j, num});
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int size = list.size();
        int[] order = new int[size];
        for (int i = 0; i < size; i++) {
            order[i] = list.get(i)[2];
        }
        return order;
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        if (k >= len) {
            return Arrays.stream(cardPoints).sum();
        }
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            sums[i] = sums[i - 1] + cardPoints[i - 1];
        }
        int ret = 0;
        for (int j = 0; j <= k; ++j) {
            ret = Math.max(ret, sums[len] - sums[len - k + j] + sums[j]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Leetcode_1478_minDistance l = new Leetcode_1478_minDistance();
        System.out.println(l.processQueries(new int[]{3, 1, 2, 1}, 5));
    }


    public int[] processQueries(int[] queries, int m) {
        int[] indice = new int[m];
        int[] arr = new int[m];
        int[] ret = new int[queries.length];
        int cur = 0;
        for (int i = 0; i < m; ++i) {
            indice[i] = i;
            arr[i] = i + 1;
        }
        for (int q : queries) {
            int idx = indice[q - 1];
            for (int p = idx; p > 0; --p) {
                arr[p] = arr[p - 1];
                indice[arr[p - 1] - 1] = p;
            }
            arr[0] = q;
            indice[q - 1] = 0;
            ret[cur++] = idx;
        }
        return ret;
    }
}
