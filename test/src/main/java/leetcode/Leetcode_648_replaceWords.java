package leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_648_replaceWords {

    public static void main(String[] args) {
        Leetcode_648_replaceWords l = new Leetcode_648_replaceWords();
        System.out.println(l.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String s : dictionary) {
            insert(root, s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String s : words) {
            stringBuilder.append(preFix(root, s));
            stringBuilder.append(" ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }


    public static class Node {
        boolean isword;
        Node[] nodes = new Node[26];

        public Node() {
            isword = false;
            nodes = new Node[26];
        }

    }

    private void insert(Node root, String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int next = word.charAt(i) - 'a';
            if (cur.nodes[next] == null) {
                cur.nodes[next] = new Node();
            }
            Node nextNode = cur.nodes[next];
            if (i == word.length() - 1) {
                nextNode.isword = true;
            }
            cur = nextNode;
        }
    }

    private String preFix(Node root, String word) {
        Node cur = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(word.charAt(i));
            int next = word.charAt(i) - 'a';
            Node nextNode = cur.nodes[next];
            if (nextNode == null) {
                break;
            } else if (nextNode.isword) {
                return stringBuilder.toString();
            }
            cur = nextNode;
        }
        return word;
    }

}