package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/5 下午5:39
 */
public class Leetcode_1052_maxSatisfied {
    public static void main(String[] args) {
        Leetcode_1052_maxSatisfied l = new Leetcode_1052_maxSatisfied();
        System.out.println(l.maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
        System.out.println(l.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(l.maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, sum = 0;
        for (int i = 0; i < minutes; i++) {
            sum += customers[i] * grumpy[i];
        }
        int res = sum;
        for (int i = minutes; i < n; i++) {
            sum += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
            res = Math.max(res, sum);
        }
        for (int i = 0; i < n; i++) {
            res += customers[i] * (grumpy[i] ^ 1);
        }
        return res;
    }

}
