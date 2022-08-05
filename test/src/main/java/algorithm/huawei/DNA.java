package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午11:12
 */
public class DNA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = Integer.parseInt(scanner.nextLine());
        System.out.println(getLongest(s, len));
    }


    public static String getLongest(String s, int n) {
        if (s.length() < n) {
            return "";
        } else if (s.length() == n) {
            return s;
        }
        int cnt = 0, maxCnt = 0;
        String ret = "";
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'G' || ch == 'C') {
                ++cnt;
            }
            if (i >= n) {
                int pre = s.charAt(i - n);
                if (pre == 'G' || pre == 'C') {
                    --cnt;
                }
            }
            if (i >= n - 1 && cnt > maxCnt) {
                ret = s.substring(i - n + 1, i + 1);
                maxCnt = cnt;
            }
        }
        return ret;
    }


}
