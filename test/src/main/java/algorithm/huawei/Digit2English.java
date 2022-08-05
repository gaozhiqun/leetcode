package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午12:01
 */
public class Digit2English {
    static long[] CARRY_DIGITS = new long[]{1000000000L, 1000000L, 1000L};
    static String[] CARRAY_NAMES = new String[]{"billion", "million", "thousand"};
    static String digitsE[] = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String digitsTENS[] = new String[]{"ten", "eleven", "twelve", "threeTeen", "fourTeen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String digitsOverTENS[] = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(getResult(scanner.nextLong()));
        }
    }

    public static String getResult(long digit) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CARRY_DIGITS.length; ++i) {
            if (digit >= CARRY_DIGITS[i]) {
                long num = digit / CARRY_DIGITS[i];
                stringBuilder.append(getDigitLessThanThousand(num));
                stringBuilder.append(" ");
                stringBuilder.append(CARRAY_NAMES[i]);
                stringBuilder.append(" ");
                digit %= CARRY_DIGITS[i];
            }
        }
        if (digit > 0) {
            stringBuilder.append(getDigitLessThanThousand(digit));
        }
        return stringBuilder.toString();
    }

    private static String getDigitLessThanThousand(long num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num >= 100) {
            stringBuilder.append(digitsE[(int) num / 100]);
            stringBuilder.append(" hundred");
            num %= 100;
            if (num > 0) {
                stringBuilder.append(" and ");
            }
            num %= 100;
        }
        if (num >= 10) {
            if (num < 20) {
                stringBuilder.append(digitsTENS[(int) num - 10]);
                num = 0;
            } else {
                stringBuilder.append(digitsOverTENS[(int) num / 10 - 2]);
                num %= 10;
            }
            stringBuilder.append(" ");
        }
        if (num != 0) {
            stringBuilder.append(digitsE[(int) num]);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
