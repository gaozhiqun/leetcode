package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午3:28
 */
public class Leetcode_1122_relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }


        return arr1;
    }
}
