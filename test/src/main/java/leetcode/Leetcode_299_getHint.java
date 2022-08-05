package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_299_getHint {
    public static void main(String[] args) {
        Leetcode_299_getHint l = new Leetcode_299_getHint();
        System.out.println(l.getHint("", ""));
        System.out.println(l.getHint("1123", "0111"));
        System.out.println(l.getHint("1807", "7810"));
        System.out.println(l.getHint("1", "1"));
        System.out.println(l.getHint("1", "0"));


    }


    /**
     * secret = "1807", guess = "7810"
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * A 表示公牛，B 表示奶牛。
     */
    public String getHint(String secret, String guess) {
        int[] cnts = new int[10];
        int m = secret.length();
        int bulls = 0, cows = m;
        for (int i = 0; i < m; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                cnts[secret.charAt(i) - '0']++;
                cnts[guess.charAt(i) - '0']--;
            }
        }
        for (int i : cnts) {
            if (i > 0) {
                cows -= i;
            }
        }
        return String.format("%sA%sB", bulls, cows - bulls);

    }


}