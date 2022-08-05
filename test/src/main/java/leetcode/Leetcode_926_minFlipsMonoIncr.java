package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_926_minFlipsMonoIncr {
    public static void main(String[] args) {
        Leetcode_926_minFlipsMonoIncr l = new Leetcode_926_minFlipsMonoIncr();
        System.out.println(l.minFlipsMonoIncr("00110"));
        System.out.println(l.minFlipsMonoIncr("00011000"));
        System.out.println(l.minFlipsMonoIncr("010110"));
    }

    public int minFlipsMonoIncr(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int M = s.length();
        int[] lOneCnts = new int[M + 1];
        int[] rZeroCnts = new int[M + 1];
        for (int i = 0; i < M; ++i) {
            char chl = s.charAt(i);
            char chr = s.charAt(M - 1 - i);
            if (chl == '1') {
                lOneCnts[i + 1] = lOneCnts[i] + 1;
            } else {
                lOneCnts[i + 1] = lOneCnts[i];
            }
            if (chr == '1') {
                rZeroCnts[M - 1 - i] = rZeroCnts[M - i] + 1;
            } else {
                rZeroCnts[M - 1 - i] = rZeroCnts[M - i];
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < M-1; ++i) {
            ret = Math.min(ret, lOneCnts[i] + rZeroCnts[i+1]);
        }
        return ret;

    }
}
