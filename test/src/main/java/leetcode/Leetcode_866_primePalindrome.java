package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_866_primePalindrome {
    public static void main(String[] args) {
        Leetcode_866_primePalindrome l = new Leetcode_866_primePalindrome();

    }

    /**
     * 1->11,
     * 11->1111/
     */

    public int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N)) {
                return N;
            }
            N++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int r = (int) Math.sqrt(n);
        for (int d = 2; d <= r; ++d) {
            if (n % d == 0) {
                return true;
            }
        }
        return false;
    }

    public int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans = 10 * ans + (n % 10);
            n /= 10;
        }
        return ans;
    }

}
