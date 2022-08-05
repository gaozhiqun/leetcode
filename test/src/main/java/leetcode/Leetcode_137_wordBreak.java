package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_137_wordBreak {

    public static void main(String[] args) {
        Leetcode_137_wordBreak l = new Leetcode_137_wordBreak();
        System.out.println(l.wordBreak2("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<String>> wordsMap = new HashMap<>();
        Set<String> wordDictSet = new HashSet(wordDict);
        for (String word : wordDictSet) {
            List<String> words = wordsMap.get(word.length());
            if (words == null) {
                words = new ArrayList<>();
                wordsMap.put(word.length(), words);
            }
            words.add(word);
        }
        List<String> ans = new ArrayList<>();
        bfs(ans, 0, s, new StringBuilder(), wordsMap);
        return ans;
    }

    private void bfs(List<String> ans, int pos, String s, StringBuilder cur, Map<Integer, List<String>> wordsMap) {
        if (pos == s.length()) {
            ans.add(cur.toString().trim());
            return;
        }
        for (Map.Entry<Integer, List<String>> entry : wordsMap.entrySet()) {
            int len = entry.getKey();
            if (pos + len > s.length()) {
                continue;
            }
            String next = s.substring(pos, pos + len);
            List<String> words = entry.getValue();
            for (String word : words) {
                if (next.equals(word)) {
                    cur.append(" ");
                    cur.append(next);
                    bfs(ans, pos + len, s, cur, wordsMap);
                    cur.delete(cur.length() - len - 1, cur.length());
                    break;
                }
            }
        }
    }
}