package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/29 上午10:29
 */
public class Leetcode_974_subarraysDivByK {
    public static void main(String[] args) {
        Leetcode_974_subarraysDivByK l = new Leetcode_974_subarraysDivByK();
        System.out.println(l.subarraysDivByK(new int[]{-1, 2, 9}, 2));
        System.out.println(l.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }


    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, ret = 0;
        Map<Integer, Integer> cntsMap = new HashMap<>();
        cntsMap.put(0, 1);
        for (int i : nums) {
            sum += i;
            int r = (sum % k + k) % k;
            int s = cntsMap.getOrDefault(r, 0);
            ret += s;
            cntsMap.put(r, s + 1);
        }
        return ret;
    }

}
