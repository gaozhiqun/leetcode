package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午7:04
 */
public class Leetcode_1131_maxAbsValExpr {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        /**
         * Use the idea that abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B).
         * |arr2[j]-arr1[i]| + |arr2[i]-arr1[j]| + |i-j|
         */
        int amin = Integer.MIN_VALUE, bmin = Integer.MIN_VALUE, cmin = Integer.MIN_VALUE, dmin = Integer.MIN_VALUE;
        int amax = Integer.MAX_VALUE, bmax = Integer.MAX_VALUE, cmax = Integer.MAX_VALUE, dmax = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < arr1.length; i++) {
            amin = Math.min(amin, arr1[i] + arr2[i] + i);
            bmin = Math.min(amin, arr1[i] + arr2[i] + i);
            cmin = Math.min(amin, arr1[i] + arr2[i] - i);
            dmin = Math.min(amin, arr1[i] + arr2[i] - i);
            amax = Math.max(amax, arr1[i] - arr2[i] + i);
            bmax = Math.max(bmax, arr1[i] - arr2[i] + i);
            cmax = Math.max(cmax, arr1[i] - arr2[i] - i);
            dmax = Math.max(dmax, arr1[i] - arr2[i] - i);
        }
        return Math.max(Math.max(dmax - dmin, cmax - cmin), Math.max(amax - amin, bmax - bmin));
    }

}
