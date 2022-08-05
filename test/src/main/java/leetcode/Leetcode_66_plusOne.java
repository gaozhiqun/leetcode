package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_66_plusOne {

    public static void main(String[] args) {
        Leetcode_66_plusOne l = new Leetcode_66_plusOne();
        System.out.println(Arrays.asList(l.plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(l.addBinary("1010", "1011"));


    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            int n;
            if (i == digits.length - 1) {
                n = digits[i] + 1 + carry;
            } else {
                n = digits[i] + carry;
            }
            digits[i] = n % 10;
            carry = n / 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
    }

    public String addBinary(String a, String b) {
        int n1 = a.length() - 1, n2 = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int n = carry;
            if (n1 >= 0) {
                n += (a.charAt(n1--) - '0');
            }
            if (n2 >= 0) {
                n += (b.charAt(n2--) - '0');
            }
            ans.append((n % 2));
            carry = n / 2;
        }
        return ans.reverse().toString();
    }
}
