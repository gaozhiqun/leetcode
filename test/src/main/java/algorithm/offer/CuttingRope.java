package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/3 3:52 下午
 */
public class CuttingRope {

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        return helper(n, 1);
    }

    private int helper(int n, int temp) {
        int result = temp * n;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, helper(n - i, temp * i));
        }
        return result;
    }


}
