package algorithm.dp;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/12 下午8:07
 */
public class Ksimilar {
    public static void main(String[] args) {

    }

    public int kSimilarityBfs(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s2);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(s1, 0);
        while (!queue.isEmpty()) {
            String next = queue.poll();
            if (s1.equals(next)) {
                return dist.get(s2);
            }
            List<String> neibors = neigbors(s1, next);
            for (String neibor : neibors) {
                if (!dist.containsKey(neibor)) {
                    queue.offer(neibor);
                    dist.put(neibor, dist.get(next) + 1);
                }
            }
        }
        throw null;
    }

    private List<String> neigbors(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff = i;
            }
        }
        List<String> result = new ArrayList<>();
        char[] chars = s1.toCharArray();
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == s2.charAt(diff)) {
                swap(chars, j, diff);
                result.add(new String(chars));
                swap(chars, j, diff);
            }
        }
        return result;
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int kSimilarity(String s1, String s2) {
        int l = s1.length();
        if (s1.length() != s2.length() && !countsEqual(s1, s2, 0, l - 1)) {
            return -1;
        }
        if (s1.equals(s2)) {
            return 0;
        }
        int count = 0;
        int[][] dp = new int[l][l];
        for (int i = l; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (countsEqual(s1, s2, i, j)) {
                    dp[i][j] = getDifferenceCnt(s1, s2, i, j);
                }
                for (int k = i + 1; k < j; k++) {
                    if (countsEqual(s1, s2, i, k) && countsEqual(s1, s2, k + 1, j)) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j], dp[i][j]);
                    }
                }
            }
        }
        return dp[0][l - 1];
    }

    private boolean countsEqual(String s1, String s2, int l, int r) {
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i = l; i <= r; i++) {
            array1[s1.charAt(i)]++;
            array2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private int getDifferenceCnt(String s1, String s2, int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result > 0 ? result - 1 : 0;
    }
}
