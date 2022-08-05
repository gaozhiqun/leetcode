package algorithm.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/22 下午2:45
 */
public class PrisonAfterNDays {
    public static void main(String[] args) {

    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> statusMap = new HashMap<>();
        Map<Integer, Integer> indexStatusMap = new HashMap<>();
        int status = 0, result, index = 0;
        for (int i = 0; i < cells.length; i++) {
            status |= (cells[i] << i);
        }
        while (!statusMap.containsKey(status)) {
            int next = getNextStatus(status);
            statusMap.put(status, next);
            indexStatusMap.put(index, status);
            status = next;
            ++index;
        }
        int N = statusMap.size();
        result = indexStatusMap.get(n % N);
        int[] ans = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            ans[i] = 1 & (result >>> i);
        }
        return ans;
    }

    private int getNextStatus(int status) {
        int next = 0;
        for (int i = 1; i <= 6; i++) {
            next |= (status << (i - 1) ^ (status << (i + 1)));
        }
        return next;
    }
}
