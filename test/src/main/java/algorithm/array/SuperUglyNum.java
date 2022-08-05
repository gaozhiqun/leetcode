package algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/1 4:04 下午
 */
public class SuperUglyNum {
    //leetcode 313 超级丑数

    public static void main(String[] args) {

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 2) {
            return 1;
        }
        int[] nums = new int[n];
        int cur = 1;
        Map<Integer, Integer> primeMap = new HashMap<>();
        for (int i : primes) {
            primeMap.put(i, 0);
        }
        while (cur < n) {
            int nextPrime = -1;
            int curMin = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : primeMap.entrySet()) {
                if (entry.getKey() * nums[entry.getValue()] < curMin) {
                    curMin = entry.getKey() * nums[entry.getValue()];
                    nextPrime = entry.getKey();
                    nums[cur] = curMin;
                }
            }
            primeMap.put(nextPrime, primeMap.get(nextPrime) + 1);
            cur++;

        }
        return nums[n - 1];
    }

}
