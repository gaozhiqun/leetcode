/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/19 8:20 下午
 */
public class ReverseKArray {
    public static void main(String[] args) {
        ReverseKArray reverseKArray = new ReverseKArray();
        System.out.println(reverseKArray.minBitFlips(new int[]{0, 1, 0}, 2));
        System.out.println(reverseKArray.minBitFlips(new int[]{0, 1, 0}, 2));

    }

    public int minBitFlips(int[] array, int n) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (i > array.length - n) {
                    return -1;
                }
                reverseArray(i, n, array);
                ++result;
            }
        }
        return result;
    }

    private void reverseArray(int j, int n, int[] array) {
        for (int i = 0; i < n; i++) {
            array[i + j] ^= 1;
        }
    }
}
