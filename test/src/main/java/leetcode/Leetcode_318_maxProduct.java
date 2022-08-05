package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_318_maxProduct {

    public static void main(String[] args) {
        Leetcode_318_maxProduct l = new Leetcode_318_maxProduct();
        System.out.println(l.maxProduct(new String[]{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        }));
        System.out.println(l.maxProduct(new String[]{
                "a", "ab", "abc", "d", "cd", "bcd", "abcd"
        }));
        System.out.println(l.maxProduct(new String[]{
                "a", "aa", "aaa", "aaaa"
        }));

    }

    public int maxProduct(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            int n = 0;
            for (char ch : s.toCharArray()) {
                n |= (1 << (ch - 'a'));
            }
            map.put(s, n);
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((map.get(words[i]) & map.get(words[j])) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }
        return ans;
    }


}