package algorithm.array;

import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/22 下午4:02
 */
public class Rand10 {
    public static void main(String[] args) {

    }

    private Random random = new Random(17);

    public int rand10() {
        int row, col, vaue;
        do {
            row = rand7();
            col = rand7();
            vaue = col + (row - 1) * 7;
        } while (vaue > 40);
        return 1 + (vaue - 1) % 10;
    }

    private int rand7() {
        return random.nextInt(7);
    }
}
