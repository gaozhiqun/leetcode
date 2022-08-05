package algorithm.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 上午11:42
 */
public class TypeDiff {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();//个数
            int[] w = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = in.nextInt();//砝码的重量
            }
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();//砝码个数
            }
            System.out.println(getDiff(n, w, nums));
        }
    }


    public static int getDiff(int n, int[] weights, int[] cnts) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; ++i) {
            int weight = weights[i], cnt = cnts[i];
            Set<Integer> temp = new HashSet<>();
            for (int cur : set) {
                for (int c = 1; c <= cnt; ++c) {
                    temp.add(cur + c * weight);
                }
            }
            set.addAll(temp);
        }
        return set.size();
    }
}
