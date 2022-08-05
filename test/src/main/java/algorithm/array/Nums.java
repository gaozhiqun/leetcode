package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/17 8:59 下午
 */
public class Nums {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 4, 1, 5, 4};
        Nums nums = new Nums();
        System.out.println(nums.eggsFall(3, 14));
        System.out.println(nums.oneTimeNum(array));
        System.out.println(nums.multiNums(new int[]{1, 3, 2, 3, 2, 4, 3, 7, 3, 3, 3}));
        System.out.println(nums.mergeTwoSortedArray(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10}));
    }

    public int oneTimeNum(int[] array) {
        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        return result;
    }

    /**
     * 出现次数大于n/2的数字
     *
     * @param array
     * @return
     */
    public int multiNums(int[] array) {
        int count = 0;
        Integer cur = null;
        for (int i : array) {
            if (cur == null) {
                cur = i;
                count = 1;
            } else if (cur == i) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cur = null;
                }
            }
        }
        return cur;
    }

    boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j > -1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private int[] mergeTwoSortedArray(int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0;
        int cur = 0;
        while (i < m && j < n) {
            if (a1[i] < a2[j]) {
                result[cur++] = a1[i++];
            } else {
                result[cur++] = a2[j++];
            }
        }
        if (i < m) {
            System.arraycopy(a1, i, result, cur, m - i);
        }
        if (j < n) {
            System.arraycopy(a2, j, result, cur, n - j);
        }
        return result;
    }

    int eggsFall(int k, int n) {
        if (n == 1) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        return eggsFall(--k, (int) Math.ceil((double) n / 2));
    }

    boolean isPalindrome(String s, int i, int j) {
        s = s.toLowerCase();
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> palindromeSubstring(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        recursive(s, 0, temp, result);
        return result;
    }

    public void recursive(String s, int cur, List<String> tempList, List<List<String>> result) {
        if (cur == s.length()) {
            result.add(new ArrayList<>(tempList));
        }
        for (int j = cur; j < s.length(); j++) {
            if (isPalindrome(s, cur, j)) {
                tempList.add(s.substring(cur, j + 1));
                recursive(s, j + 1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
