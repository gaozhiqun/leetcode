package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/4 上午11:13
 */
public class Leetcode_922_sortArrayByParityII {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] sortArrayByParityII(int[] nums) {
        int N = nums.length;
        int[] ret = new int[N];
        int i = 0, j = 1;
        for (int n : nums) {
            if (n % 2 == 0) {
                ret[i] = n;
                i += 2;
            } else {
                ret[j] = n;
                j += 2;
            }
        }
        return ret;
    }


}
