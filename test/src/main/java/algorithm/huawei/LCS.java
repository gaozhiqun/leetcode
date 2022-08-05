package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午7:22
 */
public class LCS {
    public static void main(String[] args) {
        System.out.println(lcs("nvlrzqcjltmrejybjeshffenvkeqtbsnlocoyaokdpuxutrsmcmoearsgttgyyucgzgcnurfbubgvbwpyslaeykqhaaveqxijc", "wkigrnngxehuiwxrextitnmjykimyhcbxildpnmrfgcnevjyvwzwuzrwvlomnlogbptornsybimbtnyhlmfecscmojrxekqmj"));
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(lcs(s1, s2));
    }

    //输出在较短串中最先出现的那个
    public static String lcs(String a, String b) {
        String ret = "";
        if (a.length() > b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        int m = a.length(), n = b.length();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int i1 = i, j1 = j;
                while (i1 < m && j1 < n && a.charAt(i1) == b.charAt(j1)) {
                    ++i1;
                    ++j1;
                }
                if (i1 - i > ret.length()) {
                    ret = a.substring(i, i1);
                }
            }
        }
        return ret;
    }
}
