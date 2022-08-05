package algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 上午10:59
 */
public class CharSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; ++i) {
            System.out.println(total(scanner.nextLine()));
        }
    }


    public static int total(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int ret = 0;
        for (int i = freq.length - 1; i >= 0; --i) {
            ret += ((i + 1) * freq[i]);
        }
        return ret;
    }



}
