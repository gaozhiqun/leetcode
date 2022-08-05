package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_125_isPalindrome {


    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}
