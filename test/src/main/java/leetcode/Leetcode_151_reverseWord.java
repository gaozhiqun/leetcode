package leetcode;


import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_151_reverseWord {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        Leetcode_151_reverseWord l = new Leetcode_151_reverseWord();
        System.out.println(l.reverseWords("  Bob    Loves  Alice   "));
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i >= 0; --i) {
            if ("".equals(words[i])) {
                continue;
            }
            ans.append(words[i]);
            ans.append(" ");
        }
        if (ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.toString();
    }
}