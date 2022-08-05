package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_133_gasStation {

    public static void main(String[] args) {
        Leetcode_133_gasStation l = new Leetcode_133_gasStation();
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */
        System.out.println(l.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(l.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;
        int l = 0, r = 0, tank = 0;
        while (l < m && r < 2 * m) {
            if (l < r && (l % m) == (r % m)) {
                return l;
            }
            tank += gas[r % m];
            tank -= cost[r % m];
            while (l < m && tank < 0) {
                tank -= gas[l];
                tank += cost[l];
                ++l;
            }
            ++r;
        }
        return -1;
    }
}