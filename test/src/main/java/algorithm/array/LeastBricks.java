package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午3:55
 */
public class LeastBricks {
    public static void main(String[] args) {

    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> line : wall) {
            int sum = 0;
            for (int i : line) {
                sum += i;
                cnt.put(i, cnt.getOrDefault(i, 0) + 1);
            }
        }
        return wall.size() - Collections.max(new ArrayList<Integer>(cnt.values()));

    }
}
