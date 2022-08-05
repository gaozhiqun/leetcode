package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午4:20
 */
public class Leetcode_1032_StreamChecker {

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));


    }


    public static class StreamChecker {

        public static class Trie {
            private char cur;
            private Trie[] children;
            private boolean isWord;

            public Trie() {
                this.children = new Trie[26];
            }

            public Trie(char ch, boolean isWord) {
                this.cur = ch;
                this.isWord = isWord;
                this.children = new Trie[26];
            }
        }

        private Trie root;

        private StringBuilder prefixBuilder;


        public StreamChecker(String[] words) {
            this.root = new Trie();
            this.prefixBuilder = new StringBuilder();
            for (String word : words) {
                insert(word);
            }
        }

        public boolean query(char letter) {
            prefixBuilder.append(letter);
            while (prefixBuilder.length() > 0) {
                if (prefix(prefixBuilder.toString())) {
                    break;
                } else {
                    prefixBuilder.deleteCharAt(0);
                }
            }
            return word(prefixBuilder.toString());
        }

        private void insert(String word) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                Trie next = cur.children[idx];
                if (next == null) {
                    if (i == word.length() - 1) {
                        next = new Trie(ch, true);
                    } else {
                        next = new Trie(ch, false);
                    }
                    cur.children[idx] = next;
                }
                cur = next;
            }
        }

        private boolean prefix(String prefix) {
            Trie cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                Trie next = cur.children[idx];
                if (next == null) {
                    return false;
                }
                cur = next;
            }
            return true;


        }

        private boolean word(String word) {
            Trie cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                Trie next = cur.children[idx];
                if (next == null) {
                    return false;
                }
                cur = next;
            }
            return cur.isWord;
        }

    }

}
