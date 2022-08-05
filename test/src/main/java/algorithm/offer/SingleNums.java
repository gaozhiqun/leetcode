package algorithm.offer;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/10 8:47 下午
 */
public class SingleNums {
    public static void main(String[] args) {
        SingleNums singleNums = new SingleNums();
        System.out.println(Arrays.toString(singleNums.singleNums(new int[]{1, 1, 3, 6, 2, 2, 4, 4, 8, 8})));

    }

    public int[] singleNums(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & div) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }


}
