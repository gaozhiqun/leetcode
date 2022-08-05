package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午4:34
 */
public class MinIncresementForUnique {
    public static void main(String[] args) {
        MinIncresementForUnique minIncresementForUnique = new MinIncresementForUnique();
        System.out.println(minIncresementForUnique.minIncresementForUnique(new int[]{1, 2, 2}));
        System.out.println(minIncresementForUnique.minIncresementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncresementForUnique(int[] array) {
        int ans = 0;
        Arrays.sort(array);
        int l = 0;
        while (l < array.length) {
            int r = l + 1, L = 1;
            while (r < array.length && array[r] - array[l] < r - l) {
                ++r;
                ++L;
            }
            for (int i = 0; i < L; ++i) {
                ans += Math.abs(array[l + i] - array[l] - i);
            }
            l = r;
        }
        return ans;
    }
}
