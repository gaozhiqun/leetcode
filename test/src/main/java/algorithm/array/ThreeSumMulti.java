package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 上午10:36
 */
public class ThreeSumMulti {
    public static void main(String[] args) {
        ThreeSumMulti threeSumMulti = new ThreeSumMulti();
        System.out.println(threeSumMulti.threeSumMulti(
                new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8
        ));
    }

    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[][] cntArr = new int[map.size()][2];
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cntArr[cur][0] = entry.getKey();
            cntArr[cur][1] = entry.getValue();
            ++cur;
        }
        Arrays.sort(cntArr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        long ans = 0;
        int mod = 100_000_007;
        for (int i = 0; i < cntArr.length; i++) {
            int firstCnt = cntArr[i][1];
            for (int j = i; j < cntArr.length; j++) {
                int secondCnt = cntArr[j][1];
                if (i == j) {
                    --secondCnt;
                }
                int third = target - cntArr[i][0] - cntArr[j][0];
                int thirdCnt = map.getOrDefault(third, 0);
                if (third < cntArr[j][0]) {//不重复计算
                    break;
                } else if (third == cntArr[j][0]) {
                    thirdCnt = secondCnt - 1;
                }
                System.out.println(cntArr[i][0] + " " + cntArr[j][0] + " " + third + " " + firstCnt + " " + secondCnt + " " + thirdCnt);
                ans += (firstCnt * secondCnt * thirdCnt);
                ans %= mod;
            }
        }
        return (int) ans;
    }
}
