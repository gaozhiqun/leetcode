package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午5:42
 */
public class CheckInclusion {
    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s, String l) {
        if (s.length() > l.length()) {
            return false;
        } else if (l.equals(s)) {
            return true;
        }
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        int[] tempArray = Arrays.copyOf(counts, 26);
        int temp = 0;
        int i = 0;
        while (i < l.length()) {
            char cur = l.charAt(i);
            if (tempArray[cur - 'a'] > 0) {
                tempArray[cur - 'a']--;
                temp++;
                if (temp == s.length()) {
                    return true;
                }
            } else {
                tempArray = Arrays.copyOf(counts, 26);
                temp = 0;
            }
            ++i;
        }
        return false;
    }
}
