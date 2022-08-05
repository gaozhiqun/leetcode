package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/7 下午8:59
 */
public class NumberSubArrayBoundedMax {
    public static void main(String[] args) {

    }

    public int numberSubArrayBoundedMax(int[] arrays, int l, int r) {
        return atMost(arrays, r) - atMost(arrays, l - 1);
    }

    public int atMost(int[] arrays, int l) {
        int len = 0;
        int result = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] <= l) {
                ++len;
                result += len;
            } else {
                len = 0;
            }
        }
        return result;
    }
}
