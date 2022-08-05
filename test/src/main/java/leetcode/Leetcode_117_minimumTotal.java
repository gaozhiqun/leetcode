package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_117_minimumTotal {
    public static void main(String[] args) {
        Leetcode_117_minimumTotal l = new Leetcode_117_minimumTotal();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < cur.size(); j++) {
                int temp = cur.get(j);
                temp += Math.min(j < pre.size() ? pre.get(j) : Integer.MAX_VALUE,
                        j > 0 ? pre.get(j - 1) : Integer.MAX_VALUE);
                next.add(temp);
            }
            pre = next;
        }
        int ans = pre.get(0);
        for (int i : pre) {
            ans = Math.min(ans, i);
        }
        return ans;
    }


}
