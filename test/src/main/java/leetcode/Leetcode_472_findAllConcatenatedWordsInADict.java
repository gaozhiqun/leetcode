package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_472_findAllConcatenatedWordsInADict {

    public static void main(String[] args) {
        Leetcode_472_findAllConcatenatedWordsInADict l
                = new Leetcode_472_findAllConcatenatedWordsInADict();
        System.out.println(l.findAllConcatenatedWordsInADict(new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
        }));
    }

    class Trie {
        private boolean isWord;
        private Trie[] next;

        public Trie() {
            isWord = false;
            next = new Trie[26];
        }
    }

    Trie root;

    public void add(String word) {
        Trie curNode = root;
        for (int i = 0; i < word.length(); i++) {
            int p = word.charAt(i) - 'a';
            if (curNode.next[p] == null) {
                curNode.next[p] = new Trie();
            }
            curNode = curNode.next[p];
        }
        curNode.isWord = true;
    }

    public boolean search(String word, int start, int num, Trie curNode) {
        if (start == word.length()) {
            return num >= 2;
        }
        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curNode.next[index] == null) {
                return false;
            }
            curNode = curNode.next[index];
            if (curNode.isWord && search(word, i + 1, num + 1, root)) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        root = new Trie();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (search(word, 0, 0, root)) {
                res.add(word);
            }
            add(word);
        }
        return res;
    }

    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            set.remove(word);
            if (canBreak(word, set)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }

    private boolean canBreak(String word, Set<String> set) {
        if (set.size() == 0) {
            return false;
        }

        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = true;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[n];
    }

}
