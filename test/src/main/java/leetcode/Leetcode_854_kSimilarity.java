package leetcode;

import algorithm.array.SlidingPuzzle;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_854_kSimilarity {
    public static void main(String[] args) {
        Leetcode_854_kSimilarity l = new Leetcode_854_kSimilarity();
        System.out.println(l.kSimilarity("abac", "baca"));
        System.out.println(l.kSimilarity("aabc", "abca"));
        System.out.println(l.kSimilarity("bccaba", "abacbc"));
/**
 * "bccaba"
 * "abacbc"
 */
    }

    public int kSimilarity(String A, String B) {
        Queue<String> queue = new ArrayDeque();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) return dist.get(S);
            for (String T : neighbors(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
    }

    public List<String> neighbors(String S, String target) {
        List<String> ans = new ArrayList();
        int i = 0;
        for (; i < S.length(); ++i) {
            if (S.charAt(i) != target.charAt(i)) break;
        }

        char[] T = S.toCharArray();
        for (int j = i + 1; j < S.length(); ++j)
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }

        return ans;
    }

    public void swap(char[] T, int i, int j) {
        char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }


}
