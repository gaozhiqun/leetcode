package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_13_longestCommonPrefix {
    public static void main(String[] args) {
        Leetcode_13_longestCommonPrefix l = new Leetcode_13_longestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(l.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (true) {
            Character ch = null;
            for (String s : strs) {
                if ("".equals(s)) {
                    return "";
                }
                if (i > s.length() - 1) {
                    return ans.toString();
                }
                if (ch == null) {
                    ch = s.charAt(i);
                } else if (s.charAt(i) != ch) {
                    return ans.toString();
                }
            }
            ans.append(ch);
            ++i;
        }
    }
}
