package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_208_trie {

    public static void main(String[] args) {
        Leetcode_208_trie l = new Leetcode_208_trie();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public static class Trie {

        private TriNode root;

        public Trie() {
            root = new TriNode(false);
        }

        public void insert(String word) {
            TriNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TriNode next = cur.children[ch - 'a'];
                if (next == null) {
                    next = new TriNode(false);
                    cur.children[ch - 'a'] = next;
                }
                if (i == word.length() - 1) {
                    cur.children[ch - 'a'].isword = true;
                }
                cur = next;
            }
        }

        public boolean search(String word) {
            TriNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TriNode next = cur.children[ch - 'a'];
                if (next == null) {
                    return false;
                }
                if (i == word.length() - 1) {
                    return cur.children[ch - 'a'].isword;
                }
                cur = next;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            TriNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TriNode next = cur.children[ch - 'a'];
                if (next == null) {
                    return false;
                }
                cur = next;
            }
            return true;
        }
    }

    public static class TriNode {
        private TriNode[] children;
        private boolean isword;

        public TriNode(boolean isword) {
            this.children = new TriNode[26];
            this.isword = isword;
        }
    }


}