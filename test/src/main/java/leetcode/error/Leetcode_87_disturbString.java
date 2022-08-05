package leetcode.error;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_87_disturbString {

    /**
     * 输入：s1 = "great", s2 = "rgeat""abcdefghijklmnopq"
     * "efghijklmnopqcadb"
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_87_disturbString l = new Leetcode_87_disturbString();
        System.out.println(l.isScramble("great", "rgeat"));
        System.out.println(l.isScramble("abcde", "caebd"));
        System.out.println(l.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }

    /**
     * Using dp dp[i][j][k] means: s1 i->j, s2 k, len=j-i+1, s=0->len
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else if (s1.length() == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        int l = s1.length();
        boolean ans = false;
        for (int len = 1; len < l; len++) {
            String sl1 = s1.substring(0, len);
            String sr1 = s1.substring(len, l);
            String sl2 = s2.substring(0, len);
            String sr2 = s2.substring(len, l);
            String rsr2 = s2.substring(0, l - len);
            String rsl2 = s2.substring(l - len, l);
            if (isScramble(sl1, sl2) && isScramble(sr1, sr2)) {
                return true;
            }
            if (isScramble(sl1, rsl2) && isScramble(sr1, rsr2)) {
                return true;
            }
        }
        return ans;
    }


}
