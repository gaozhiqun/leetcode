package algorithm.huawei;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/2 下午3:43
 */
public class AEIOU2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        s = s.toLowerCase();
        System.out.println(longest(s, m));
    }

    public static int longest(String s, int m) {
        if (m > s.length()) {
            return 0;
        }
        int ret = 0;
        int unSatisfied = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = Character.toLowerCase(s.charAt(r));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (unSatisfied == m) {
                    char pre = Character.toLowerCase(s.charAt(l));
                    if (pre == 'a' || pre == 'e' || pre == 'i' || pre == 'o' || pre == 'u') {
                        ret = Math.max(ret, (r - l + 1));
                    }
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
