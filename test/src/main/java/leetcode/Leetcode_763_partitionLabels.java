package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_763_partitionLabels {
    public static void main(String[] args) {
        Leetcode_763_partitionLabels l = new Leetcode_763_partitionLabels();
        System.out.println(l.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        int cur = 0, l = 0, r = -1;
        while (cur < m) {
            r = Math.max(r, last[s.charAt(cur) - 'a']);
            if (cur == r) {
                ans.add(r - l + 1);
                l = r + 1;
            }
            cur++;
        }
        return ans;
    }

}
