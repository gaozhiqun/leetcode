package algorithm.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午7:25
 */
public class SubArraybitWiseOrs {
    public static void main(String[] args) {

    }

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x : A) {
            Set<Integer> cur2 = new HashSet<>();
            for (int y : cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}
