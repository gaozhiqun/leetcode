package leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_649_predictPartyVictory {

    public static void main(String[] args) {
        Leetcode_649_predictPartyVictory l = new Leetcode_649_predictPartyVictory();
    }

    /**
     * 禁止一名参议员的权利：
     * <p>
     * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
     * <p>
     * 宣布胜利：
     * 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dota2-senate
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }


}