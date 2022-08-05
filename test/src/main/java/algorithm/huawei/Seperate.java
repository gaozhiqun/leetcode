package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 下午4:11
 */
public class Seperate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; ++i) {
            arr[i] = in.nextInt();
        }
        System.out.println(divide(0, 0, arr));
    }


    public static boolean divide(int i, int val, int[] arr) {
        if (i == arr.length) {
            return val == 0;
        }
        if (arr[i] % 5 == 0) {
            return divide(i + 1, val + arr[i], arr);
        } else if (arr[i] % 3 == 0) {
            return divide(i + 1, val - arr[i], arr);
        } else {
            return divide(i + 1, val + arr[i], arr)
                    || divide(i + 1, val - arr[i], arr);
        }
    }
}
