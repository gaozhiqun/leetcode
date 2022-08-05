package leetcode;


import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_43_multiply {

    public static void main(String[] args) {
        Leetcode_43_multiply l = new Leetcode_43_multiply();
        String ans = l.multiply("0", "0");
        System.out.println(ans);
        ans = l.multiply("123", "456");
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] temp = new int[m + n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[m + n - i - j - 2] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carries = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m + n; ++i) {
            int num = temp[i] + carries;
            ans.append(num % 10);
            carries = num / 10;
        }
        while (ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        ans.reverse();
        if (carries > 0) {
            return carries + ans.toString();
        }
        return ans.toString();
    }


}
