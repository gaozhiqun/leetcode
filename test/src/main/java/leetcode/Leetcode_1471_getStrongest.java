package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/1 下午2:31
 */
public class Leetcode_1471_getStrongest {

    public static void main(String[] args) {
        Leetcode_1471_getStrongest l = new Leetcode_1471_getStrongest();
        System.out.println(l.getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5));
    }


    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        // 排序
        Arrays.sort(arr);
        int[] ans = new int[k];
        int L = 0;
        int R = n - 1;
        int m = arr[(n - 1) / 2];
        int idx = 0;
        while (idx != k) {
            if (Math.abs(arr[L] - m) > Math.abs(arr[R] - m)) {
                ans[idx++] = arr[L];
                L++;
            } else if (Math.abs(arr[L] - m) <= Math.abs(arr[R] - m)) {
                ans[idx++] = arr[R];
                R--;
            }
        }
        return ans;
    }

}
