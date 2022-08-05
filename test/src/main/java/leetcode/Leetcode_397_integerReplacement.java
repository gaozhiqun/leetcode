package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_397_integerReplacement {
    public static void main(String[] args) {
        Leetcode_397_integerReplacement l = new Leetcode_397_integerReplacement();

    }

    /**
     * 0*nums[0] + 1*nums[0];
     * 1*nums[0] + 2*nums[1]....+0*nums[n-1];
     * f(i) = f(i-1)+ n*nums[i-1];
     * 15->16->8->4->2->1
     */

    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }
}



