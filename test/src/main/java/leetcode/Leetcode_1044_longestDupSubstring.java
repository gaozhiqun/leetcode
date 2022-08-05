package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/15 下午7:47
 */
public class Leetcode_1044_longestDupSubstring {

    /**
     * 最长重复字串
     *
     * @param s
     * @return 2 <= s.length <= 3 * 104
     * s 由小写英文字母组成
     * Rabin-Karp 's algorithm.
     * 卡普-拉宾算法
     */

    public String longestDupSubstring(String s) {
        Random random = new Random();
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;

        int N = s.length();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = s.charAt(i) - 'a';
        }

        int l = 1, r = N - 1, len = 0, start = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int idx = check(arr, mid, a1, a2, mod1, mod2);
            if (idx != -1) {
                l = mid + 1;
                len = mid;
                start = idx;
            } else {
                r = mid - 1;
            }
        }
        return start != -1 ? s.substring(start, start + len) : "";
    }

    public int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1);
        long aL2 = pow(a2, m, mod2);
        long h1 = 0, h2 = 0;
        for (int i = 0; i < m; ++i) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        Set<Long> seen = new HashSet<Long>();
        seen.add(h1 * mod2 + h2);
        for (int start = 1; start <= n - m; ++start) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }

            long num = h1 * mod2 + h2;
            if (!seen.add(num)) {
                return start;
            }
        }
        return -1;
    }

    public long pow(int a, int m, int mod) {
        long ans = 1;
        long contribute = a;
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod;
                if (ans < 0) {
                    ans += mod;
                }
            }
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            m /= 2;
        }
        return ans;
    }


    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

}
