package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午5:24
 */
public class Leetcode_12_romanToInt {

    public static void main(String[] args) {
        Leetcode_12_romanToInt l = new Leetcode_12_romanToInt();
        System.out.println(l.romanToInt("MCMXCIV"));
    }


    /**
     * 1<=num<=3999
     *
     * @param num
     * @return
     */

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = map.get(s.charAt(i));
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > n) {
                ans -= n;
            } else {
                ans += n;
            }
        }
        return ans;
    }
}
