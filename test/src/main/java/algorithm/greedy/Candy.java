package algorithm.greedy;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/21 9:34 下午
 */
public class Candy {
    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.leastCandy(new int[]{1, 0, 2}));
        System.out.println(candy.leastCandy(new int[]{1, 2, 2}));


    }

    public int leastCandy(int[] performance) {
        int m = performance.length;
        if (m == 1) {
            return 1;
        }
        int result = 0;
        int[] assigns = new int[m];
        Arrays.fill(assigns, 1);
        for (int i = 0; i < m; i++) {
            int j = i + 1;
            while (j < m && performance[j] > performance[j - 1]) {
                assigns[j] = Math.max(assigns[j], assigns[j - 1] + 1);
                j++;
            }
            j = i;
            while (j > 0 && performance[j] < performance[j - 1]) {
                assigns[j - 1] = Math.max(assigns[j - 1], assigns[j] + 1);
                j--;
            }
        }
        for (int num : assigns) {
            result += num;
        }
        return result;
    }
}
