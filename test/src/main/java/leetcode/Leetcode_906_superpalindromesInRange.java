package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/25 下午2:49
 */
public class Leetcode_906_superpalindromesInRange {

    public static void main(String[] args) {
        Leetcode_906_superpalindromesInRange l = new Leetcode_906_superpalindromesInRange();
    }


    public int superpalindromesInRange(String left, String right) {
        Long L = Long.parseLong(left), R = Long.parseLong(right);
        long MAGIC = 1000000;
        int ans = 0;
        for (int k = 1; k < MAGIC; ++k) {
            long v = getPalind(k, true);
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalidrome(v)) {
                ans++;
            }
        }
        for (int k = 1; k < MAGIC; ++k) {
            long v = getPalind(k, false);
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalidrome(v)) {
                ans++;
            }
        }
        return ans;

    }

    private Long getPalind(long N, boolean odd) {
        StringBuilder s = new StringBuilder(String.valueOf(N));
        if (odd) {
            s.deleteCharAt(s.length() - 1);
        }
        String newDigit = N + s.toString();
        return Long.parseLong(newDigit);
    }

    private boolean isPalidrome(long v) {
        return String.valueOf(v).equals(new StringBuilder(String.valueOf(v)).reverse().toString());
    }


}
