package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午2:55
 */
public class Leetcode_421_findMaximumXOR {
    public static void main(String[] args) {
        Leetcode_421_findMaximumXOR l = new Leetcode_421_findMaximumXOR();
        System.out.println(new int[]{
                14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70
        });

    }

    static final int HIGH_BIT = 30;


    /**
     * 最大异或值 分组
     */
    public int findMaximumXOR(int[] nums) {

        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }
}

