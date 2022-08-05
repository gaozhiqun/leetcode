package algorithm.huawei;

import java.io.IOException;
import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/21 下午8:36
 */
public class HungarianAlgorithm {
    /**
     * 匈牙利算法
     * 1. 给当前的数找匹配项，如果有就使用，先到先得
     * 2. 其他人尝试抢占当前匹配，如果抢占成功，并且被抢占的能找到其他项，则替换
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        HungarianAlgorithm main = new HungarianAlgorithm();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] tempArray = new int[n];
            for (int i = 0; i < n; i++) {
                tempArray[i] = scan.nextInt();
            }
            System.out.println(main.getMax(tempArray));
        }
//        System.out.println(main.getMax(new int[]{20923, 22855, 2817, 1447,
//                29277, 19736, 20227, 22422, 24712, 27054,
//                27050, 18272, 5477, 27174, 13880, 15730,
//                7982, 11464, 27483, 19563, 5998, 16163}));
//        System.out.println(main.getMax(new int[]{4, 5, 6, 7}));

    }

    public int getMax(int[] nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i : nums) {
            if (((i & 1) ^ 1) == 0) {
                odds.add(i);
            } else {
                evens.add(i);
            }
        }
        int[] matches = new int[odds.size()];
        int ret = 0;
        for (int i = 0; i < evens.size(); ++i) {
            boolean[] used = new boolean[odds.size()];
            int even = evens.get(i);
            if (find(even, odds, matches, used)) {
                ++ret;
            }
        }
        return ret;
    }

    private boolean find(int even, List<Integer> odds, int[] matches, boolean[] used) {
        for (int i = 0; i < odds.size(); ++i) {
            int odd = odds.get(i);
            if (isPrime(even + odd) && !used[i]) {
                used[i] = true;
                if (matches[i] == 0 || find(matches[i], odds, matches, used)) {
                    matches[i] = even;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
            if (num == 1) {
                return false;
            }
        }
        return true;
    }
}
