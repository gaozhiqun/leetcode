package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_212_findWords {

    public static void main(String[] args) {
        Leetcode_212_findWords l = new Leetcode_212_findWords();
        System.out.println(l.findWords(new char[][]{
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     * <p>
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * @param board
     * @param words
     * @return
     */
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, i, j, trie.root, ans);
            }
        }
        return new ArrayList<>(ans);

    }

    private void dfs(char[][] board, int i, int j, TriNode parent, Set<String> ans) {
        char ch = board[i][j];
        TriNode next = parent.children.get(ch);
        if (next == null) {
            return;
        }
        if (!"".equals(next.word)) {
            ans.add(next.word);
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                dfs(board, ni, nj, next, ans);
            }
        }
        board[i][j] = ch;
    }

    public static class Trie {

        private TriNode root;

        public Trie() {
            root = new TriNode("");
        }

        public void insert(String word) {
            TriNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TriNode next = cur.children.get(ch);
                if (next == null) {
                    next = new TriNode("");
                    cur.children.put(ch, next);
                }
                if (i == word.length() - 1) {
                    cur.children.get(ch).word = word;
                }
                cur = next;
            }
        }

        public boolean search(String word) {
            TriNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TriNode next = cur.children.get(ch);
                if (next == null) {
                    return false;
                }
                if (i == word.length() - 1) {
                    return word.equals(cur.children.get(ch).word);
                }
                cur = next;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            TriNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TriNode next = cur.children.get(ch);
                if (next == null) {
                    return false;
                }
                cur = next;
            }
            return true;
        }
    }

    public static class TriNode {
        public Map<Character, TriNode> children;
        public String word;

        public TriNode(String word) {
            this.children = new HashMap<>();
            this.word = word;
        }
    }


}