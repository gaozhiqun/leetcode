package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午10:38
 */
public class BigDigitCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(sum(a, b));
    }


    public static String sum(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int i = m - 1, j = n - 1, carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int digit = carry;
            if (i >= 0) {
                digit += (str1.charAt(i) - '0');
                --i;
            }
            if (j >= 0) {
                digit += (str2.charAt(j) - '0');
                --j;
            }
            stringBuilder.append(digit % 10);
            carry = digit / 10;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
