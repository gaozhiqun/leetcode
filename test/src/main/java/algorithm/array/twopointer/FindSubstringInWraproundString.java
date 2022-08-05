package algorithm.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午3:39
 */
public class FindSubstringInWraproundString {
    public static void main(String[] args) {
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        System.out.println(findSubstringInWraproundString.findSubStringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString.findSubStringInWraproundString("zab"));
    }

    /**
     * 前缀和
     *
     * @param p
     * @return
     */
    public int findSubStringInWraproundString(String p) {
        Map<Character, Integer> lenMap = new HashMap<>();
        int w = 1;
        lenMap.put(p.charAt(0), w);
        for (int r = 1; r < p.length(); r++) {
            if (p.charAt(r) - p.charAt(r - 1) == 1 || p.charAt(r) - p.charAt(r - 1) == -25) {
                w += 1;
            } else {
                w = 1;
            }
            lenMap.put(p.charAt(r),
                    Math.max(w, lenMap.getOrDefault(p.charAt(r), 0)));
        }
        int ans = 0;
        for (int i : lenMap.values()) {
            ans += i;
        }
        return ans;
    }
}
