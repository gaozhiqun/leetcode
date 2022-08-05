package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_554_breakingWalls {


    public static void main(String[] args) {
        Leetcode_554_breakingWalls l = new Leetcode_554_breakingWalls();
    }

    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size(), ans = m;
        Map<Integer, Integer> cnts = new HashMap<>();
        for (List<Integer> line : wall) {
            int sum = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                sum += line.get(i);
                cnts.put(sum, cnts.getOrDefault(sum, 0) + 1);
            }
        }
        for (int n : cnts.values()) {
            ans = Math.min(ans, m - n);
        }
        return ans;
    }


}