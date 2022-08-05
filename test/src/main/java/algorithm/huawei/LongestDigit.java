package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 下午3:45
 */
public class LongestDigit {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String d = subDigit(in.nextLine());
            System.out.println(String.format("%s,%s", d, LEN));
        }
    }

    private static int LEN;

    public static String subDigit(String s) {
        StringBuilder sb = new StringBuilder();
        LEN = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    ++j;
                }
                if (j - i == LEN) {
                    sb.append(s.substring(i, j));
                } else if (j - i > LEN) {
                    LEN = j - i;
                    sb = new StringBuilder(s.substring(i, j));
                }
                i = j;
            }
        }
        return sb.toString();
    }
}
