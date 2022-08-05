package algorithm.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/15 下午8:08
 */
public class ReorganizeString {
    public static void main(String[] args) {

    }

    /**
     * 某个字符超过一半直接return false
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        int[] cnts = new int[26];
        Character cur = null;
        int counts = 0;
        for (char ch : s.toCharArray()) {
            if (counts == 0) {
                cur = ch;
            }
            if (cur == ch) {
                counts++;
            } else {
                counts--;
            }
            cnts[ch - 'a']++;
        }
        if (counts > 1) {
            return "";
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < 26; ++i) {
            if (cnts[i] > 0) {
                priorityQueue.offer(new int[]{i, cnts[i]});
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int first = 0, second = 0;
        Character a = null, b = null;
        while (!priorityQueue.isEmpty()) {
            if (first == 0) {
                int[] next = priorityQueue.poll();
                first = next[1];
                a = (char) (next[0] + 'a');
            }
            if (second == 0) {
                int[] next = priorityQueue.poll();
                second = next[1];
                b = (char) (next[0] + 'a');
            }
            int round = Math.min(first, second);
            for (int i = 0; i < round; i++) {
                stringBuilder.append(a);
                stringBuilder.append(b);
            }
            first -= round;
            second -= round;
        }
        return stringBuilder.toString();

    }


}
