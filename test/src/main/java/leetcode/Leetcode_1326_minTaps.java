package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/30 下午12:17
 */
public class Leetcode_1326_minTaps {


    public int minTaps(int n, int[] ranges) {
        int[][] coverArray = new int[n + 1][2];
        for (int i = 0; i < ranges.length; ++i) {
            coverArray[i] = new int[]{Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i])};
        }
        Arrays.sort(coverArray, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < coverArray.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(coverArray[i]);
            } else if (stack.peek()[1] >= coverArray[i][1]) {
                continue;
            } else if (stack.peek()[1] < coverArray[i][0]) {
                return -1;
            } else {
                while (stack.size() > 1) {
                    int[] pre = stack.pop();
                    if (stack.peek()[1] >= coverArray[i][0]) {
                        continue;
                    } else {
                        stack.push(pre);
                        break;
                    }
                }
                stack.push(coverArray[i]);
            }
        }
        return stack.size();
    }


    int m, n;

    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 0; i < m; i++) {
            diagonalSort(mat, i, 0);
        }
        for (int j = 1; j < n; j++) {
            diagonalSort(mat, 0, j);
        }
        return mat;
    }

    public void diagonalSort(int[][] mat, int startRow, int startCol) {
        int length = Math.min(m - startRow, n - startCol);
        for (int i = 1; i < length; i++) {
            int num = mat[startRow + i][startCol + i];
            int insertIndex = i;
            for (int j = i - 1; j >= 0 && mat[startRow + j][startCol + j] > num; j--) {
                mat[startRow + j + 1][startCol + j + 1] = mat[startRow + j][startCol + j];
                insertIndex = j;
            }
            if (insertIndex != i) {
                mat[startRow + insertIndex][startCol + insertIndex] = num;
            }
        }
    }


    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int m = nums.length;
        int ret = nums[m - 1] - nums[0];
        for (int i = 0; i <= 3; ++i) {
            ret = Math.min(ret, nums[m - 4 + i] - nums[i]);
        }
        return ret;
    }


    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MODULO;
        }
        return ans;
    }

    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int col = row[i][j];
                for (int k = i; k >= 0 && col != 0; --k) {
                    col = Math.min(col, row[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }


    public int getLastMoment(int n, int[] left, int[] right) {
        int ret = 0;
        for (int i : left) {
            ret = Math.max(ret, i);
        }
        for (int i : right) {
            ret = Math.max(ret, n - i);
        }
        return ret;

    }


    /**
     * 最小元素与最大元素的 和 小于或等于 target
     * max + min <=target
     * 注意越界
     */
    public int numSubseq(int[] nums, int target) {
        int MOD = (int) 1e9 + 7, n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < f.length; ++i) {
            f[i] = (f[i - 1] << 1) % MOD;
        }

        Arrays.sort(nums);
        int l = 0, r = n - 1;
        long ret = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                ret = (ret + f[r - l]) % MOD;
                l++;
            }
        }
        return (int) (ret + MOD) % MOD;
    }


    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for (int num : arr) {
            ++mod[(num % k + k) % k];
        }
        for (int i = 1; i + i < k; ++i) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }
        return mod[0] % 2 == 0;
    }


    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int m = rains.length;
        int[] ret = new int[m];
        Arrays.fill(ret, 1);
        for (int i = 0; i < m; ++i) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                ret[i] = -1;
                if (map.containsKey(rains[i])) {
                    int l = map.get(rains[i]);
                    if (set.isEmpty() || set.higher(l) == null) {
                        return new int[0];
                    } else {
                        int match = set.higher(l);
                        set.remove(match);
                        ret[match] = rains[i];
                        map.remove(rains[i]);
                    }
                } else {
                    map.put(rains[i], i);
                }
            }
        }
        return ret;
    }

    public String[] getFolderNames(String[] names) {
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        int m = names.length;
        String[] ret = new String[m];
        for (int i = 0; i < m; ++i) {
            String name = names[i];
            if (name.contains("(")) {
                String realName = name.substring(0, name.indexOf('('));
                int digit = Integer.parseInt(name.substring(name.indexOf('(') + 1, name.indexOf(')')));
                TreeSet<Integer> set = map.computeIfAbsent(realName, f -> new TreeSet<>());
                if (set.isEmpty() || !set.contains(digit)) {
                    set.add(digit);
                    ret[i] = name;
                } else {
                    int next = set.isEmpty() ? 0 : set.first();
                    while (set.contains(next)) {
                        set.remove(next);
                        ++next;
                    }
                    set.add(next);
                    ret[i] = realName + "(" + next + ")";
                }
            } else {
                TreeSet<Integer> set = map.computeIfAbsent(name, f -> new TreeSet<>());
                int next = set.isEmpty() ? 0 : set.first();
                while (set.contains(next)) {
                    set.remove(next);
                    ++next;
                }
                set.add(next);
                if (next > 0) {
                    ret[i] = name + "(" + next + ")";
                } else {
                    ret[i] = name;
                }
            }
        }
        return ret;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / k < m) {
            return -1;
        }
        int l = Arrays.stream(bloomDay).min().getAsInt(),
                r = Arrays.stream(bloomDay).max().getAsInt();
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (canMake(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int fc = 0, rc = 0;
        for (int i = 0; i < bloomDay.length; ++i) {
            if (bloomDay[i] <= day) {
                ++fc;
                if (fc == k) {
                    ++rc;
                    fc -= k;
                }
            } else {
                fc = 0;
            }
        }
        return rc >= m;
    }


    public static void main(String[] args) {
        Leetcode_1326_minTaps l = new Leetcode_1326_minTaps();
        // System.out.println(l.minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(l.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
        System.out.println(l.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(l.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(l.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }

}
