package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_890_findAndReplacePattern {
    public static void main(String[] args) {
        Leetcode_890_findAndReplacePattern l = new Leetcode_890_findAndReplacePattern();
        System.out.println(l.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

    /**
     * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * 输出：["mee","aqq"]
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                ret.add(word);
            }
        }
        return ret;

    }

    public boolean match(String ori, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < ori.length(); i++) {
            char v = ori.charAt(i);
            char k = pattern.charAt(i);
            if (v != map.computeIfAbsent(k, f -> v) || k != reverseMap.computeIfAbsent(v, f -> k)) {
                return false;
            }
        }
        return true;
    }

}
