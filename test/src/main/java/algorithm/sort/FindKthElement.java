package algorithm.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/15 上午11:02
 */
public class FindKthElement {
    public static void main(String[] args) {
        FindKthElement findKthElement = new FindKthElement();
        System.out.println(findKthElement.findKthLargest(new int[]{10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2}, 3));
    }

    private int findKthLargest(int[] arr, int K) {
        int l = 0, r = arr.length - 1;
        K = arr.length - K;
        int p = partition(arr, l, r);
        while (p != K) {
            if (p > K) {
                r = p - 1;
            } else {
                l = p + 1;
            }
            p = partition(arr, l, r);
        }
        return arr[p];
    }


    /**
     * 优化
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] arr, int l, int r) {
        int poviet = arr[l];
        while (l < r) {
            while (r > l && arr[r] >= poviet) {
                --r;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= poviet) {
                ++l;
            }
            arr[r] = arr[l];
        }
        arr[l] = poviet;
        return l;
    }


    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            int num = numbers[i];
            int idx = map.getOrDefault(target - num, -1);
            if (idx >= 0) {
                return new int[]{idx, i};
            }
            map.put(num, i);
        }
        return null;

    }



}
