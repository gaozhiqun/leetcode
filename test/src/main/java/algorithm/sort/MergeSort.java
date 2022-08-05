package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/14 下午5:08
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] num = new int[]{5, 2, 3, 1, 4};
        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.GetLeastNumbers_Solution(num, 3));
        mergeSort.mergeSort(num);
        for (int i : num) {
            System.out.println(i);
        }
    }

    private void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, l, r - l + 1);
    }

    /**
     * 其中不去重的最小的 k 个数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input.length <= k) {
            for (int i : input) {
                ret.add(i);
            }
            return ret;
        }
        for (int i = input.length / 2 - 1; i >= 0; --i) {
            heapAdjust(input, i, input.length);
        }
        for (int i = input.length - 1, j = 0; i > 0 && j < k; --i, ++j) {
            swap(input, 0, i);
            ret.add(input[i]);
            heapAdjust(input, 0, i);
        }
        return ret;

    }


    private void heapAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) {
                ++k;
            }
            if (temp < arr[k]) {
                break;
            }
            arr[i] = arr[k];
            i = k;
        }
        arr[i] = temp;
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
