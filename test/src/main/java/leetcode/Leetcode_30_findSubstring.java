package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_30_findSubstring {

    public static void main(String[] args) {
        Leetcode_30_findSubstring leetcode_30_findSubstring = new Leetcode_30_findSubstring();
        System.out.println(leetcode_30_findSubstring.findSubstring("wordgoodgoodgoodbestword", new String[]{
                "word", "good", "best", "good"
        }));

        System.out.println(leetcode_30_findSubstring.findSubstring("wordgoodgoodgoodbestword", new String[]{
                "word", "good", "best", "word"
        }));
        System.out.println(leetcode_30_findSubstring.findSubstring("barfoofoobarthefoobarman", new String[]{
                "bar", "foo", "the"
        }));
        System.out.println(leetcode_30_findSubstring.findSubstring("", new String[]{
                "bar", "foo", "the"
        }));
    }

    /**
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * "wordgoodgoodgoodbestword"
     * ["word","good","best","good"]
     *
     * @param s
     * @param words
     * @return
     */

    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, l = words[0].length();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> cnts = new HashMap<>();
        for (String word : words) {
            cnts.put(word, cnts.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - m * l; ++i) {
            String sub = s.substring(i, i + m * l);
            if (dfs(sub, 0, cnts)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(String s, int cur, Map<String, Integer> cnts) {
        if (cur == s.length()) {
            return true;
        }
        boolean ans = false;
        for (String candidate : cnts.keySet()) {
            if (cnts.get(candidate) > 0 && s.substring(cur, cur + candidate.length()).equals(candidate)) {
                cnts.put(candidate, cnts.get(candidate) - 1);
                ans = dfs(s, cur + candidate.length(), cnts);
                cnts.put(candidate, cnts.get(candidate) + 1);
                return ans;
            }
        }
        return ans;
    }


}
