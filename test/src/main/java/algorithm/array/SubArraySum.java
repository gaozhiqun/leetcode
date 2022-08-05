package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午4:34
 */
public class SubArraySum {


    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.subarraySum(new int[]{1, 1, 1}, 2));
    }


    public int subarraySum2(int[] array, int n) {
        int preSum = 0;
        int result = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for (int i : array) {
            preSum += i;
            result += cnt.getOrDefault(preSum - n, 0);
            cnt.put(preSum, cnt.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }


    public int subarraySum(int[] array, int n) {//当n为正数时成立
        int l = 0, r = 0, sum = 0, result = 0;
        while (r < array.length) {
            sum += array[l];
            while (sum > n) {
                sum -= array[l++];
            }
            if (sum == n) {
                ++result;
            }
            r++;
        }
        return result;
    }


}
