package algorithm.dp;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/18 6:39 下午
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.firstUnique("loveleetcode"));
        System.out.println(wordBreak.firstUnique("leetcode"));
        System.out.println(wordBreak.wordBreak2("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));


    }


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    //拆分成不同的单词
    //DFS
    public List<List<String>> wordBreak2(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        wordBreakDfs(s, 0, wordDict, temp, result);
        return result;
    }

    public void wordBreakDfs(String s, int cur, List<String> wordDict, List<String> temp, List<List<String>> result) {
        if (cur >= s.length()) {
            result.add(new ArrayList<>(temp));
        }
        for (String word : wordDict) {
            if (cur + word.length() <= s.length() && word.equals(s.substring(cur, cur + word.length()))) {
                temp.add(word);
                wordBreakDfs(s, cur + word.length(), wordDict, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static class TrieNode {
        private char c;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isLeaf;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            HashMap<Character, TrieNode> children = root.getChildren();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node;
                if (children.containsKey(c)) {
                    node = children.get(c);
                } else {
                    node = new TrieNode(c);
                    children.put(c, node);
                }
                children = node.getChildren();

                if (i == word.length() - 1) {
                    node.setLeaf(true);
                }
            }
        }

        public boolean search(String word) {
            HashMap<Character, TrieNode> children = root.getChildren();

            TrieNode node = null;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (children.containsKey(c)) {
                    node = children.get(c);
                    children = node.getChildren();
                } else {
                    node = null;
                    break;
                }
            }
            if (node != null && node.isLeaf()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int firstUnique(String s) {
        int[] temp = new int[26];
        Arrays.fill(temp, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (temp[ch - 'a'] > -1) {
                temp[ch - 'a'] = Integer.MAX_VALUE;
            } else {
                temp[ch - 'a'] = i;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i : temp) {
            if (i > -1) {
                result = Math.min(result, i);
            }
        }
        return result;
    }

    /**
     * 乘积最大的子数组 偶数个负数， 包含且不包含0
     *
     * @param arrays
     */
    public void maximumMultiValue(int[] arrays) {
        Queue<Integer> queue = new ArrayDeque<>();
        int l = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                result = 0;
                queue.offer(i);
            }
        }
    }

    /**
     * 计算只有正/负的结果
     *
     * @param arrays
     * @param l
     * @param r
     * @return
     */
    public int calculate(int[] arrays, int l, int r) {
        return -1;
    }

    private int[] topK(int[] array, int k) {
        int l = 0;
        int h = 0;
        do {
            int cur = partition(array, l, h);
        } while (l != k);
        return Arrays.copyOf(array, k);
    }

    private int partition(int[] array, int low, int high) {
        int p = array[low];
        int l = low;
        int r = high;
        while (l < r) {
            while (array[l] <= p && l < r) {
                l++;
            }
            while (array[r] >= p && l < r) {
                r--;
            }
            swap(array, l, r);
        }
        array[low] = array[l];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        array[l] = p;
        return l;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }




}
