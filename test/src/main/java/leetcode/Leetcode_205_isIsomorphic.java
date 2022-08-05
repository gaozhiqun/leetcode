package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_205_isIsomorphic {

    public static void main(String[] args) {
        Leetcode_205_isIsomorphic l = new Leetcode_205_isIsomorphic();
        System.out.println(l.isIsomorphic("paper", "title"));
        System.out.println(l.isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        Map<Character, Character> s2tmap = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i), b = t.charAt(i);
            if (b != s2tmap.getOrDefault(a, b) || a != t2s.getOrDefault(b, a)) {
                return false;
            }
            s2tmap.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}