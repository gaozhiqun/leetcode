package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午8:29
 */
public class XorGame {
    public static void main(String[] args) {

    }

    public boolean xorGame(int[] nums) {
        int result = 0;
        if (nums.length % 2 == 0) {
            return true;
        }
        for (int i : nums) {
            result ^= i;
        }
        return result == 0;
    }


}
