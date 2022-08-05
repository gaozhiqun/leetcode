package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/2 下午4:32
 */
public class Leetcode_1015_smallestRepunitDivByK {
    public static void main(String[] args) {
        Leetcode_1015_smallestRepunitDivByK l = new Leetcode_1015_smallestRepunitDivByK();
        System.out.println(l.smallestRepunitDivByK(7));
    }


    /**
     * (n * 10 % k + 1) % k == 0
     */
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int len = 1;
        long cur = 1;
        while (cur % k != 0) {
            cur = cur % k;
            cur = cur * 10 + 1;
            len++;
        }
        return len;
    }

}
