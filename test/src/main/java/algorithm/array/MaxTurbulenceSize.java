package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/26 上午10:25
 */
public class MaxTurbulenceSize {
    public static void main(String[] args) {
        MaxTurbulenceSize maxTurbulenceSize = new MaxTurbulenceSize();
        System.out.println(maxTurbulenceSize.maxTurbulenceSize(new int[]{
                9, 4, 2, 10, 7, 8, 8, 1, 9
        }));
        System.out.println(maxTurbulenceSize.maxTurbulenceSize(new int[]{
                4, 8, 12, 16
        }));
    }

    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 0, ans = 1, m = arr.length;
        while (r < m - 1) {
            if (l == r) {
                if (arr[l] == arr[l + 1]) {
                    ++l;
                }
                ++r;
            } else {
                if (arr[r - 1] < arr[r] && arr[r] > arr[r + 1]
                        || arr[r - 1] > arr[r] && arr[r] < arr[r + 1]) {
                    ++r;
                } else {
                    l = r;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
