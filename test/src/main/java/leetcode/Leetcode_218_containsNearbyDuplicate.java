package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_218_containsNearbyDuplicate {

    public static void main(String[] args) {
        Leetcode_218_containsNearbyDuplicate l = new Leetcode_218_containsNearbyDuplicate();
        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(l.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(l.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(l.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(l.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * abs(nums[i] - nums[j]) <= t
     * abs(i - j) <= k
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}