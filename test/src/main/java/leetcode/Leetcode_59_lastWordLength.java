package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_59_lastWordLength {

    public static void main(String[] args) {
        Leetcode_59_lastWordLength l = new Leetcode_59_lastWordLength();
        System.out.println(l.lengthOfLastWord("Hello World"));
        System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(l.lengthOfLastWord("luffy is still joyboy"));

    }


    public int lengthOfLastWord(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int ans = 0, r = s.length() - 1;
        while (r >= 0 && s.charAt(r) == ' ') {
            --r;
        }
        while (r >= 0 && Character.isAlphabetic(s.charAt(r))) {
            --r;
            ++ans;
        }
        return ans;
    }
}
