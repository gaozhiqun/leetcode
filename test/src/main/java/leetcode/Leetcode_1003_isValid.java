package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/1 下午7:58
 */
public class Leetcode_1003_isValid {
    public static void main(String[] args) {
        Leetcode_1003_isValid l = new Leetcode_1003_isValid();
        System.out.println(l.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(l.commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(l.isValid("aabcbc"));
        System.out.println(l.isValid("abcabcababcc"));
        System.out.println(l.isValid("abccba"));
    }

    public boolean isValid(String s) {
        int[] cnts = new int[3];
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;

            if (cnts[2] > cnts[1] || cnts[1] > cnts[0] ||
                    (cnts[0] - cnts[1] > 1) ||
                    (cnts[0] == cnts[1] && (cnts[1] - cnts[2]) > 1)) {
                return false;
            }
        }
        return cnts[0] == cnts[1] && cnts[1] == cnts[2];
    }

    private String shrink(String s) {
        if ("".equals(s) || s.length() < 3) {
            return s;
        }
        for (int m = 1; m < s.length() - 1; ++m) {
            if (s.charAt(m - 1) == 'a' && s.charAt(m) == 'b' && s.charAt(m + 1) == 'c') {
                String next = s.substring(0, m - 1) + s.substring(m + 2);
                return shrink(next);
            }
        }
        return s;
    }

    public List<String> commonChars(String[] words) {
        int N = words[0].length();
        int[] cnts = new int[26];
        Arrays.fill(cnts, N);

        for (String s : words) {
            int[] sCnts = new int[26];
            for (char ch : s.toCharArray()) {
                sCnts[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnts[i] = Math.min(cnts[i], sCnts[i]);
            }
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < cnts[i]; j++) {
                ret.add("" + (char) (i + 'a'));
            }
        }
        return ret;
    }

}
