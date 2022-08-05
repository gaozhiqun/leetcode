package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午9:23
 */
public class FindLongestWord {

    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord.findLongestWord("abpcplea", list));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        int len = Integer.MIN_VALUE;
        String result = "";
        for (String d : dictionary) {
            if (isLongest(s, d) && d.length() > len) {
                len = d.length();
                result = d;
            }
        }
        return result;

    }

    public boolean isLongest(String l, String s) {
        int i = 0, j = 0;
        while (i < l.length() && j < s.length()) {
            if (l.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s.length();
    }
}
