package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午10:31
 */
public class Leetcode_1190_reverseParentheses {
    public static void main(String[] args) {
        Leetcode_1190_reverseParentheses l = new Leetcode_1190_reverseParentheses();
        System.out.println(l.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }


    public String reverseParentheses(String s) {
        while (s.lastIndexOf('(') != -1) {
            s = handleString(s);
        }
        return s;
    }


    private String handleString(String s) {
        int l = -1, r = 0;
        while (s.charAt(r) != ')') {
            if (s.charAt(r) == '(') {
                l = r;
            }
            ++r;
        }
        String pre = s.substring(0, l);
        String after = s.substring(r + 1);
        StringBuilder mid = new StringBuilder(s.substring(l + 1, r));
        mid.reverse();
        return pre + mid.toString() + after;
    }
}
