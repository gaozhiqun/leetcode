package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/2 下午3:43
 */
public class AEIOU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        if ("".equals(s)) {
            System.out.println(0);
        }
        String ret = longest(s, m);
        System.out.println(ret.length());
    }

    public static String longest(String s, int m) {
        String ret = "";
        int unSatisfied = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = Character.toLowerCase(s.charAt(r));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (unSatisfied == m && (r - l + 1) > ret.length()) {
                    ret = s.substring(l, r + 1);
                }
            } else {
                ++unSatisfied;
                while (unSatisfied > m) {
                    char pre = Character.toLowerCase(s.charAt(l));
                    if (pre == 'a' || pre == 'e' || pre == 'i' || pre == 'o' || pre == 'u') {
                        //doNothing
                    } else {
                        --unSatisfied;
                    }
                    ++l;
                }
            }
            ++r;
        }
        return ret;
    }

}
