package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午1:42
 */
public class OriginalDigits {
    public static void main(String[] args) {
        OriginalDigits originalDigits = new OriginalDigits();
        System.out.println(originalDigits.originalDigits("owoztneoer"));
        System.out.println(originalDigits.originalDigits("fviefuro"));
    }

    public static String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public String originalDigits(String s) {
        int[] counts = new int[26];
        int[][] demands = new int[10][26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (int i = 0; i < nums.length; i++) {
            for (char ch : nums[i].toCharArray()) {
                demands[i][ch - 'a']++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            String result = dfs("", i, counts, demands);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private String dfs(String cur, int i, int[] counts, int[][] demands) {
        boolean satisfied = true;
        int[] remainCounts = new int[26];
        for (int j = 0; j < 26; j++) {
            remainCounts[j] = counts[j] - demands[i][j];
            if (remainCounts[j] < 0) {
                return null;
            } else if (remainCounts[j] > 0) {
                satisfied = false;
            }
        }
        if (satisfied) {
            return cur + i;
        }
        for (int j = 0; j < 10; j++) {
            String result = dfs(cur + i, j, remainCounts, demands);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}