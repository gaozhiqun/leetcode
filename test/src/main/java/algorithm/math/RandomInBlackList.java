package algorithm.math;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午1:36
 */
public class RandomInBlackList {
    public static void main(String[] args) {
        RandomInBlackList randomInBlackList = new RandomInBlackList(9, new int[]{1, 3, 7});
        for (int i = 0; i < 100; ++i) {
            System.out.println(randomInBlackList.pick());
        }
    }

    /**
     * [0,n) 不重复黑名单，返回一个不在黑名单里的随机整数
     * 映射就可以了
     *
     *
     * @param n
     * @param blackList
     */

    private int max;
    private int total;
    private Random r;
    private Map<Integer, Integer> value;

    public RandomInBlackList(int n, int[] blackList) {
        this.max = n;
        this.total = n - blackList.length;
        this.r = new Random();
        value = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = total; i < n; ++i) {
            set.add(i);
        }
        for (int i : blackList) {
            set.remove(i);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i : blackList) {
            if (i < total) {
                value.put(i, iterator.next());
            }
        }
    }

    public int pick() {
        int k = r.nextInt(total);
        return value.getOrDefault(k, k);
    }
}
