package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_754_reachNumber {

    public static void main(String[] args) {
        Leetcode_754_reachNumber l = new Leetcode_754_reachNumber();
        System.out.println(l.reachNumber(3));
        System.out.println(l.reachNumber(2));
    }

    /**
     * @param target 选出delta 个往后走
     * @return
     */

    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;

    }


}