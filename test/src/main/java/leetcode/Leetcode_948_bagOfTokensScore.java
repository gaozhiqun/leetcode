package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 下午5:30
 */
public class Leetcode_948_bagOfTokensScore {
    public static void main(String[] args) {
        Leetcode_948_bagOfTokensScore l = new Leetcode_948_bagOfTokensScore();
        System.out.println(l.bagOfTokensScore(new int[]{71, 55, 82}, 54));
        System.out.println(l.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(l.bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(l.bagOfTokensScore(new int[]{100}, 50));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int cur = 0, ret = 0;
        while (l <= r) {
            if (power < tokens[l]) {
                power += tokens[r];
                --cur;
                --r;
                if (cur < 0) {
                    break;
                }
            } else {
                power -= tokens[l];
                ++cur;
                ret = Math.max(ret, cur);
                ++l;
            }
        }
        return ret;
    }
}
