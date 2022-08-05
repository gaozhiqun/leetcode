package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_319_bubble_switch {

    public static void main(String[] args) {
        Leetcode_319_bubble_switch l = new Leetcode_319_bubble_switch();
        System.out.println(l.bulbSwitch(3));
        System.out.println(l.bulbSwitch(0));
        System.out.println(l.bulbSwitch(1));
    }

    /**
     * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。
     * 接下来的第二轮，你将会每两个灯泡关闭一个。
     * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
     * 找出并返回 n 轮后有多少个亮着的灯泡。
     * 1->n each
     * 2->n/2 every 2
     * 3->n/3 every 3
     * 4->n/4
     * 它才会有奇数个约数，否则一定有偶数个约数。
     * 只需要找出 1, 2, \cdots, n1,2,⋯,n 中的完全平方数的个数即可
     */

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }


}