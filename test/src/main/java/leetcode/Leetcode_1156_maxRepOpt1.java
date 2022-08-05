package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/5 下午2:21
 */
public class Leetcode_1156_maxRepOpt1 {
    public static void main(String[] args) {
        Leetcode_1156_maxRepOpt1 leetcode_1156_maxRepOpt1 = new Leetcode_1156_maxRepOpt1();
        System.out.println(leetcode_1156_maxRepOpt1.maxRepOpt1("bbababaaaa"));
        System.out.println(leetcode_1156_maxRepOpt1.maxRepOpt1("aaabaaa"));
        System.out.println(leetcode_1156_maxRepOpt1.maxRepOpt1("aaabbaaa"));
        System.out.println(leetcode_1156_maxRepOpt1.maxRepOpt1("aaaaa"));
        System.out.println(leetcode_1156_maxRepOpt1.maxRepOpt1("abcdef"));
    }


    public int maxRepOpt1(String text) {
        int[] remains = new int[26];
        int[] pres = new int[26];
        for (char ch : text.toCharArray()) {
            remains[ch - 'a']++;
        }
        Character a = null, b = null;
        int ac = 0, bc = 0;
        int l = 0, ret = 0;
        for (int r = 0; r < text.length(); ++r) {
            char c = text.charAt(r);
            remains[c - 'a']--;
            if (a == null) {
                a = c;
                ac = 1;
            } else if (a == c) {
                ++ac;
            } else if (b == null) {
                b = c;
                bc = 1;
            } else if (b == c) {
                ++bc;
            }
            while (l < r && b != null && ((a != c && b != c) || (ac > 1 && bc > 1))) {
                int p = text.charAt(l++);
                if (a == p) {
                    --ac;
                    if (ac == 0) {
                        a = c;
                        ac = 1;
                    }
                } else if (b == p) {
                    --bc;
                    if (bc == 0) {
                        b = c;
                        bc = 1;
                    }
                }
                pres[p - 'a']++;
            }
            boolean canBorrow = ac == 0 || bc == 0
                    || (ac >= bc && (remains[a - 'a'] > 0 || pres[a - 'a'] > 0))
                    || (bc >= ac && (remains[b - 'a'] > 0 || pres[b - 'a'] > 0));
            ret = Math.max(ret, canBorrow ? ac + bc : ac + bc - 1);
        }
        return ret;
    }


}
