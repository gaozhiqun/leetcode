package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午10:32
 */
public class MinWindow {

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String ans = minWindow.minWindow("adobecodebanc", "abc");
        System.out.println(ans);
    }

    //s 中涵盖 t
    public String minWindow(String s, String t) {
        int l = 0, r = 0, min = Integer.MAX_VALUE;
        String ans = "";
        int[] tFreq = new int[26];
        int[] sFreq = new int[26];
        for (char ch : t.toCharArray()) {
            tFreq[ch - 'a']++;
        }
        while (r < s.length()) {
            sFreq[s.charAt(r) - 'a']++;
            while (equal(tFreq, sFreq)) {
                if (r - l < min) {
                    ans = s.substring(l, r + 1);
                }
                sFreq[s.charAt(l) - 'a']--;
                ++l;
            }
            r++;
        }
        return ans;
    }

    private boolean equal(int[] a, int[] b) {
        for (int i = 0; i < 26; ++i) {
            if (a[i] > 0 && a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}
