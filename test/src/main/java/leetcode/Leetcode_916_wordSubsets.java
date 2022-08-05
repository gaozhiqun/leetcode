package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Leetcode_916_wordSubsets {
    public static void main(String[] args) {
        Leetcode_916_wordSubsets l = new Leetcode_916_wordSubsets();
        System.out.println(l.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"e", "o"}));

    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] cnts = subSet(words2);
        List<String> ret = new ArrayList<>();
        outter:
        for (String a : words1) {
            int[] curcnts = getCnts(a);
            for (int i = 0; i < 26; ++i) {
                if (curcnts[i] < cnts[i]) {
                    continue outter;
                }
            }
            ret.add(a);
        }
        return ret;
    }


    private int[] subSet(String[] words) {
        int[] cnts = new int[26];
        for (String b : words) {
            int[] newcnts = new int[26];
            for (char ch : b.toCharArray()) {
                newcnts[ch - 'a']++;
                cnts[ch - 'a'] = Math.max(cnts[ch - 'a'], newcnts[ch - 'a']);
            }
        }
        return cnts;
    }

    private int[] getCnts(String word) {
        int[] cnts = new int[26];
        for (char ch : word.toCharArray()) {
            cnts[ch - 'a']++;
        }
        return cnts;
    }

    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                stack.push(ch);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                ret.append(stack.pop());
            } else {
                ret.append(ch);
            }
        }
        return ret.toString();

    }
}
