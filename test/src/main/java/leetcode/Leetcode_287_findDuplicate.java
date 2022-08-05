package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_287_findDuplicate {
    public static void main(String[] args) {
        Leetcode_287_findDuplicate l = new Leetcode_287_findDuplicate();
    }

    /**
     * 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     * 1 <= n <= 105
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * 不能修改原数组
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = fast;
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }


}
