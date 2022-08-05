package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/9 下午8:39
 */
public class DeleteAndEarn {
    public static void main(String[] args) {

    }

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> valueCntsMap = new TreeMap<>();
        int pre = -1, preValue = 0, prePreValue = 0;
        for (int i : nums) {
            valueCntsMap.put(i, valueCntsMap.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : valueCntsMap.entrySet()) {
            int cur = entry.getKey();
            int cnt = entry.getValue();
            int temp = Math.max(preValue, cur * cnt + (pre == cur - 1 ? prePreValue : preValue));
            prePreValue = preValue;
            preValue = temp;
            pre = cur;
        }
        return preValue;
    }
}
