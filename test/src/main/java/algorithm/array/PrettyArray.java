package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 下午4:53
 */
public class PrettyArray {
    public static void main(String[] args) {
        PrettyArray prettyArray = new PrettyArray();
        int[] result = prettyArray.beautifulArray(7);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] beautifulArray(int n) {
        int[] arr = new int[n];
        fillArray(0, n - 1, 1, n, arr);
        return arr;
    }

    public void fillArray(int l, int r, int low, int high, int[] arr) {
        if (l == r) {
            arr[l] = low;
            return;
        }
        int L = r - l + 1;
        if (L % 2 != 0) {
            int mid = (low + high) / 2;
            arr[l++] = mid;
        }
        fillArray(l, l + L / 2 - 1, high - L / 2 + 1, high, arr);
        fillArray(l + L / 2, r, low, low + L / 2 - 1, arr);
    }
    /**
     * 奇偶
     */

}
