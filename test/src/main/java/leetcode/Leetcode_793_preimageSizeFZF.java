package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 下午8:28
 */
public class Leetcode_793_preimageSizeFZF {
    public static void main(String[] args) {

    }

    public int preimageSizeFZF(long K) {
        long l = 4 * K, r = 5 * K + 1;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long n = zeta(mid);
            if (n == K) {
                return 5;
            } else if (n < K) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return 0;
    }

    public long zeta(long x) {
        if (x == 0) {
            return 0;
        }
        return x / 5 + zeta(x / 5);
    }

    public int numMatchingSubseq(String s, String[] words) {
        int ret = 0;
        for (String word : words) {
            if (match(s, word)) {
                ++ret;
            }
        }
        return ret;
    }

    private boolean match(String l, String s) {
        int i = 0, j = 0;
        while (i < l.length()) {
            if (l.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length()) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public String customSortString(String order, String s) {
        int[] idexOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            idexOrder[order.charAt(i) - 'a'] = i;
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> {
            return idexOrder[a - 'a'] - idexOrder[b - 'a'];
        });
        for (char ch : order.toCharArray()) {
            priorityQueue.offer(ch);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char ch = priorityQueue.poll();
            int cnt = map.getOrDefault(ch, 0);
            for (int i = 0; i < cnt; ++i) {
                ans.append(ch);
            }
            map.remove(ch);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                ans.append(entry.getKey());
            }
        }
        return ans.toString();

    }


}
