package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_76_minWindow {

    public static void main(String[] args) {
        Leetcode_76_minWindow l = new Leetcode_76_minWindow();
        System.out.println(l.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(l.minWindow("a", "a"));
//        System.out.println(l.minWindow("a", "aa"));


    }

    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        if (s.equals(t)) {
            return s;
        }
        String ans = s;
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> cmpMap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        boolean found = false;
        while (r < s.length()) {
            char cur = s.charAt(r);
            cmpMap.put(cur, cmpMap.getOrDefault(cur, 0) + 1);
            while (cover(cmpMap, targetMap)) {
                found = true;
                if (r - l + 1 < ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                char pop = s.charAt(l);
                cmpMap.put(pop, cmpMap.getOrDefault(pop, 0) - 1);
                ++l;
            }
            r++;
        }
        if (found) {
            return ans;
        }
        return "";
    }

    public boolean cover(Map<Character, Integer> cmp, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            int m = entry.getValue(), n = cmp.getOrDefault(entry.getKey(), 0);
            if (m > n) {
                return false;
            }
        }
        return true;
    }

}
