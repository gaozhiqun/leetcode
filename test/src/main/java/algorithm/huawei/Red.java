package algorithm.huawei;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午9:16
 */
public class Red {
    public static void main(String[] args) {
        System.out.println(maxIncrease(new int[]{2, 5, 1, 5, 4, 5}));

    }


    public static int maxIncrease(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ret = 0;
        for (int i : arr) {
            Map<Integer, Integer> headMap = treeMap.headMap(i - 1);
            int max = treeMap.getOrDefault(i, 1);
            for (int c : headMap.values()) {
                max = Math.max(c + 1, max);
            }
            ret = Math.max(ret, max);
            treeMap.put(i, max);
        }
        return ret;
    }
}
