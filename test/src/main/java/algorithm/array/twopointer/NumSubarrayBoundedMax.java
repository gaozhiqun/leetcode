package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午2:39
 */
public class NumSubarrayBoundedMax {
    public static void main(String[] args) {
        NumSubarrayBoundedMax numSubarrayBoundedMax = new NumSubarrayBoundedMax();
        System.out.println(numSubarrayBoundedMax.numSubarrayBoundedMax(
                new int[]{2, 1, 4, 3}, 2, 3
        ));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return getLessThan(A, R) - getLessThan(A, L - 1);
    }

    public int getLessThan(int[] A, int n) {
        int ans = 0, cur = 0;
        for (int x : A) {
            cur = x <= n ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}
