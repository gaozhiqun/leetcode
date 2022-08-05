package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_893_numSpecialEquivGroups {
    public static void main(String[] args) {
        Leetcode_893_numSpecialEquivGroups l = new Leetcode_893_numSpecialEquivGroups();
        System.out.println(l.numSpecialEquivGroups(new String[]{
                "ababaa", "aaabaa"
        }));
        System.out.println(l.numSpecialEquivGroups(new String[]{
                "abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"
        }));
        System.out.println(l.numSpecialEquivGroups(new String[]{
                "abc", "acb", "bac", "bca", "cab", "cba"
        }));

    }

    public int numSpecialEquivGroups(String[] words) {
        Set<String> group = new HashSet<>();
        for (String word : words) {
            group.add(serlize(word));
        }
        return group.size();
    }

    private String serlize(String word) {
        TreeMap<Character, Integer> odd = new TreeMap<>();
        TreeMap<Character, Integer> even = new TreeMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (i % 2 == 0) {
                even.put(ch, even.getOrDefault(ch, 0) + 1);
            } else {
                odd.put(ch, odd.getOrDefault(ch, 0) + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : even.entrySet()) {
            ans.append(entry.getKey());
            ans.append(entry.getValue());
        }
        for (Map.Entry<Character, Integer> entry : odd.entrySet()) {
            ans.append(entry.getKey());
            ans.append(entry.getValue());
        }
        return ans.toString();
    }


}
