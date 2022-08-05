package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_201_rangBiwiseAnd {

    public static void main(String[] args) {
        Leetcode_201_rangBiwiseAnd l = new Leetcode_201_rangBiwiseAnd();
        System.out.println(l.rangeBitwiseAnd(5, 7));
        System.out.println(l.rangeBitwiseAnd(1, 2147483647));
    }


    public int rangeBitwiseAnd(int left, int right) {
        int ans = left & right;
        int gap = right - left;
        int mask = 0;
        while (gap > 0) {
            mask = (mask << 1) | 1;
            gap /= 2;
        }
        ans &= ~mask;
        return ans;
    }


}