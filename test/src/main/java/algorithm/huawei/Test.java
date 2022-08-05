package algorithm.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午5:47
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; ++i) {
            arr[i] = in.nextInt();
        }
        System.out.println(maxIncrease(arr));

    }

    public static int maxIncrease(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ret = 0;
        for (int i : arr) {
            Map<Integer, Integer> headMap = treeMap.headMap(i);
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
