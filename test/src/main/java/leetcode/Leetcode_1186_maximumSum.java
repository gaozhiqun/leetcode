package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午10:04
 */
public class Leetcode_1186_maximumSum {
    public static void main(String[] args) {
        Leetcode_1186_maximumSum l = new Leetcode_1186_maximumSum();
        System.out.println(l.maximumSum(new int[]{1, -4, -5, -2, 5, 0, -1, 2}));
        System.out.println(l.maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(l.maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(l.maximumSum(new int[]{-1, -1, -1, -1}));
    }


    public int maximumSum(int[] arr) {
        int m = arr.length;
        // a: 未删除 b 删除
        int a = arr[0], b = 0, ans = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            b = Math.max(b + arr[i], a);
            a = Math.max(a + arr[i], arr[i]);
            ans = Math.max(ans, Math.max(a, b));
        }
        return ans;
    }
}
