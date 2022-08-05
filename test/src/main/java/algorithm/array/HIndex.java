package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/28 4:29 下午
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
    }


    public int hIndex(int[] array) {
        Arrays.sort(array);
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length - i >= array[i]) {
                result = Math.max(result, array[i]);
            }
        }
        return result;
    }

    public int hIndex2(int[] citations) {
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == n - pivot) return n - pivot;
            else if (citations[pivot] < n - pivot) left = pivot + 1;
            else right = pivot - 1;
        }
        return n - left;
    }

}
