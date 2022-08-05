package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_565_arrayNesting {


    public static void main(String[] args) {
        Leetcode_565_arrayNesting leetcode_560_subarraySum = new Leetcode_565_arrayNesting();
        System.out.println(leetcode_560_subarraySum.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(leetcode_560_subarraySum.arrayNesting(new int[]{0}));
        System.out.println(leetcode_560_subarraySum.checkInclusion("ab", "eidbaooo"));
        System.out.println(leetcode_560_subarraySum.checkInclusion("ab", "eidboaoo"));
    }

    public int arrayNesting(int[] nums) {
        int m = nums.length;
        boolean[] visited = new boolean[m];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                ans = Math.max(ans, jump(visited, nums, i));
            }
        }
        return ans;

    }

    private int jump(boolean[] visited, int[] nums, int cur) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        return 1 + jump(visited, nums, nums[cur]);
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