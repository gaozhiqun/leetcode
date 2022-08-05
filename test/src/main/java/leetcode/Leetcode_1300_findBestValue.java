package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/29 下午2:38
 */
public class Leetcode_1300_findBestValue {
    public static void main(String[] args) {
        Leetcode_1300_findBestValue l = new Leetcode_1300_findBestValue();
//        System.out.println(l.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
//        System.out.println(l.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(l.maxDistance(new int[][]{
                {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
        }));
    }


    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int m = arr.length;
        int sum = 0, gap = Integer.MAX_VALUE, ret = arr[m - 1];
        int pre = -1;
        for (int i = 0; i < m; ++i) {
            int cur = arr[i];
            int can = (target - sum) / (m - i);
            if (can > pre && can <= cur) {//good try this
                int diff = Math.abs(target - sum - can * (m - i));
                if (diff < gap) {
                    gap = diff;
                    ret = can;
                }
            }
            ++can;
            if (can > pre && can <= cur) {//good try this
                int diff = Math.abs(target - sum - can * (m - i));
                if (diff < gap) {
                    gap = diff;
                    ret = can;
                }
            }
            sum += arr[i];
            pre = arr[i];
        }
        return ret;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] u2dSum = new int[m + 1][n];
        int[][] l2rSum = new int[m][n + 1];
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                l2rSum[i][j + 1] = mat[i][j] + l2rSum[i][j];
                System.out.print(l2rSum[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("---------");
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                u2dSum[i + 1][j] = mat[i][j] + u2dSum[i][j];
                System.out.print(u2dSum[i][j] + " ");
            }
            System.out.println("");
        }

        //dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(u2dSum[i][j],l2rSum[i][j]));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = mat[i][j], k = 1;
                if (sum > threshold) {
                    continue;
                }
                while (sum < threshold && i + k < m && j + k < n) {
                    sum += (l2rSum[i][j + k + 1] - l2rSum[i][j]
                            + u2dSum[i + k + 1][j] - u2dSum[i][j] - mat[i][j]);
                    ++k;
                }
                ret = Math.max(ret, k);
            }
            System.out.println("");
        }
        return ret;
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int rmax = intervals[0][1], ret = intervals.length;
        for (int i = 1; i < intervals.length; ++i) {
            int[] next = intervals[i];
            if (rmax >= next[1]) {
                --ret;
            }
            rmax = Math.max(next[1], rmax);
        }
        return ret;
    }


    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int total = 0;
            for (int num : nums) {
                total += (num - 1) / mid + 1;
            }
            if (total <= threshold) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j])
                            , dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int k = groupSizes[i];
            List<Integer> list = map.computeIfAbsent(k, f -> new ArrayList<>());
            list.add(i);
            if (list.size() == k) {
                ret.add(list);
                map.put(k, new ArrayList<>());
            }
        }
        return ret;
    }


    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        // arr1[i] +arr2[j] +i
        // arr1[i] -arr2[j] +i
        // arr1[i] +arr2[j] -i
        // arr1[i] -arr2[j] -i
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE, minC = Integer.MAX_VALUE, minD = Integer.MAX_VALUE;
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE, maxD = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            minA = Math.min(minA, arr1[i] + arr2[i] + i);
            minB = Math.min(minB, arr1[i] - arr2[i] + i);
            minC = Math.min(minC, arr1[i] + arr2[i] - i);
            minD = Math.min(minD, arr1[i] - arr2[i] - i);
            maxA = Math.max(maxA, arr1[i] + arr2[i] + i);
            maxB = Math.max(maxB, arr1[i] - arr2[i] + i);
            maxC = Math.max(maxC, arr1[i] + arr2[i] - i);
            maxD = Math.max(maxD, arr1[i] - arr2[i] - i);
        }
        return Math.max(Math.max(maxA - minA, maxB - minB),
                Math.max(maxC - minC, maxD - minD));

    }

    //离它最近的陆地单元格的距离是最大的

    public int maxDistance(int[][] grid) {
        System.out.println(bfs(2, 2, grid));
        int ret = 0;
        boolean foundSea = false, foundLand = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 0) {
                    ret = Math.max(ret, bfs(i, j, grid));
                    foundSea = true;
                } else {
                    foundLand = true;
                }
            }
        }
        return foundSea && foundLand ? ret : -1;
    }


    private int bfs(int i, int j, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        set.add(i * m + j);
        int ret = 0;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++ret;
            for (int s = 0; s < size; ++s) {
                int[] cur = queue.poll();
                for (int d = 0; d < 4; ++d) {
                    int ni = cur[0] + dirs[d], nj = cur[1] + dirs[d + 1];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == 1) {
                        return ret;
                    } else if (!set.contains(ni * m + nj)) {
                        set.add(ni * m + nj);
                        queue.offer(new int[]{ni, nj});
                    }
                }

            }
        }
        return ret;
    }


    public List<String> invalidTransactions(String[] transactions) {
        Arrays.sort(transactions, (a, b) -> {
            String[] ad = a.split(",");
            String[] bd = a.split(",");
            if (ad[0].equals(bd[0])) {
                return Integer.compare(Integer.parseInt(ad[1]), Integer.parseInt(bd[1]));
            } else {
                return ad[0].compareTo(bd[0]);
            }
        });
        List<Integer> index = new ArrayList<>();
        String[] pre = null;
        for (int i = 0; i < transactions.length; ++i) {
            String[] cur = transactions[i].split(",");
            if (i > 0 && pre[0].equals(cur[0]) && Integer.parseInt(cur[1]) - Integer.parseInt(pre[1]) <= 60) {
                if (index.size() == 0 || (index.size() > 0 && index.get(index.size() - 1) != i - 1)) {
                    index.add(i - 1);
                }
                index.add(i);
            } else if (Integer.parseInt(cur[2]) > 1000) {
                index.add(i);
            }
            pre = cur;
        }
        List<String> ret = new ArrayList<>();
        for (int i : index) {
            ret.add(transactions[i]);
        }
        return ret;


    }
}

