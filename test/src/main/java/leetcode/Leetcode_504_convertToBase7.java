package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_504_convertToBase7 {

    public static void main(String[] args) {
        Leetcode_504_convertToBase7 l = new Leetcode_504_convertToBase7();
        System.out.println(l.convertToBase7(100));
        System.out.println(l.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        boolean positive = (num > -1);
        num = Math.abs(num);
        while (num > 0) {
            ans.append(num % 7);
            num /= 7;
        }
        if (!positive) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }
}