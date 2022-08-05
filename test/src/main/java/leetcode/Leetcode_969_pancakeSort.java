package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午7:11
 */
public class Leetcode_969_pancakeSort {
    public static void main(String[] args) {
        Leetcode_969_pancakeSort l = new Leetcode_969_pancakeSort();
    }

    /**
     * @param arr
     * @return 第一步选择 k = \textit{index} + 1k=index+1，然后反转子数组 \textit{arr}[0 ... k - 1]arr[0...k−1]，此时该元素已经被放到首部。
     * <p>
     * 第二步选择 k = \textit{n}k=n，其中 \textit{n}n 是数组 \textit{arr}arr 的长度，然后反转整个数组，此时该元素已经被放到尾部。
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, n - 1);
            ret.add(index + 1);
            ret.add(n);
        }
        return ret;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        int m = x == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(x));
        int n = y == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(y));
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (cur <= bound) {
                    ans.add(cur);
                }
            }
        }
        return new ArrayList<>(ans);
    }



}
