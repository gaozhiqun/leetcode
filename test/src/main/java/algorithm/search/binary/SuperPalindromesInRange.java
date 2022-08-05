package algorithm.search.binary;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 上午10:27
 */
public class SuperPalindromesInRange {
    public static void main(String[] args) {

    }

    public int superPalindromesInRange(String l, String r) {
        long L = Long.valueOf(l), R = Long.valueOf(r);
        int ans = 0;
        int MAGIC = 1000000;
        for (int k = 1; k < MAGIC; ++k) {
            String cur = getPalidromeString(k, true);
            long v = Long.valueOf(cur);
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalidrome(v)) {
                ans++;
            }
        }
        for (int k = 1; k < MAGIC; ++k) {
            String cur = getPalidromeString(k, false);
            long v = Long.valueOf(cur);
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

    private String getPalidromeString(int k, boolean odd) {
        String s = String.valueOf(k);
        StringBuilder stringBuilder = new StringBuilder(s);
        if (odd) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return s + stringBuilder.reverse();
    }

    private boolean isPalidrome(long v) {
        return String.valueOf(v).equals(new StringBuilder(String.valueOf(v)).reverse().toString());
    }
}
