package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午7:21
 */
public class PancakeSort {
    /**
     * 煎饼排序
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    //两次翻转，找到最大的，翻转到0，然后翻转到最后
    public List<Integer> pancakeSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; --i) {
            int max = i;
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int l = i, r = max;
            while (l < r) {
                swap(l++, r--, arr);
            }
        }
        return new ArrayList<>();

    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
