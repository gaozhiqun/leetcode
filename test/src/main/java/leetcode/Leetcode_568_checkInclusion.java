package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_568_checkInclusion {


    public static void main(String[] args) {
        Leetcode_568_checkInclusion leetcode_560_subarraySum = new Leetcode_568_checkInclusion();
        System.out.println(leetcode_560_subarraySum.checkInclusion("ab", "eidbaooo"));
        System.out.println(leetcode_560_subarraySum.checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] cnts = new int[26];
        int[] cmp = new int[26];
        for (char ch : s1.toCharArray()) {
            cnts[ch - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s2.length()) {
            char cur = s2.charAt(r++);
            cmp[cur - 'a']++;
            while (l < s2.length() && cmp[cur - 'a'] > cnts[cur - 'a']) {
                cmp[s2.charAt(l++) - 'a']--;
            }
            if (compare(cmp, cnts)) {
                return true;
            }
        }
        return false;

    }

    private boolean compare(int[] o, int[] a) {
        for (int i = 0; i < 26; i++) {
            if (o[i] != a[i]) {
                return false;
            }
        }
        return true;
    }
}