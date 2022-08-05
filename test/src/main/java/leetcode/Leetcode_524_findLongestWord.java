package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_524_findLongestWord {


    public static void main(String[] args) {
        Leetcode_524_findLongestWord l = new Leetcode_524_findLongestWord();
        List<String> dict = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(l.findLongestWord("abpcplea", dict));
    }


    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                for (int i = 0; i < s2.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return Character.compare(s1.charAt(i), s2.charAt(i));
                    }
                }
                return 0;
            }
            return s2.length() - s1.length();
        });
        for (String d : dictionary) {
            if (contain(s, d)) {
                return d;
            }
        }
        return "";
    }

    private boolean contain(String l, String s) {
        int i = 0, j = 0;
        while (i < l.length() && j < s.length()) {
            if (l.charAt(i) == s.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return j == s.length();
    }


}