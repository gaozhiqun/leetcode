package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_470_rand10 {

    Random random = new Random(17);

    public int rand10() {
        int row, col, n;
        do {
            row = rand7();
            col = rand7();
            n = row + (col - 1) * 7;
        } while (n > 40);
        return 1 + (n - 1) % 10;
    }

    private int rand7() {
        return random.nextInt(7);
    }
}
