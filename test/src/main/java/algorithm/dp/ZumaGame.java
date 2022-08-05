package algorithm.dp;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/20 下午7:38
 */
public class ZumaGame {
    public static void main(String[] args) {
        ZumaGame zumaGame = new ZumaGame();
        System.out.println(zumaGame.vanish("WWBRRRBBWW"));
        System.out.println(zumaGame.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(zumaGame.findMinStep("RBYYBBRRB", "YRBGB"));
    }

    /**
     * WRRBW RB
     * WWRRBBWW
     *
     * @param board
     * @param hand
     * @return
     */
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : hand.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        int result = backtrack(board, counts);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private int backtrack(String board, Map<Character, Integer> counts) {
        if ("".equals(board)) {
            return 0;
        }
        if (counts.isEmpty()) {
            return -1;
        }
        int result = -1;
        int len = board.length();
        for (int i = 0; i < len; i++) {
            char ch = board.charAt(i);
            int count = counts.getOrDefault(ch, 0);
            if (count > 0) {
                String newBoard = vanish(board.substring(0, i + 1) + ch + board.substring(i + 1));
                --count;
                if (count == 0) {
                    counts.remove(ch);
                } else {
                    counts.put(ch, count);
                }
                int next = backtrack(newBoard, counts);
                if (next != -1) {
                    if (result < 0) {
                        result = 1 + next;
                    } else {
                        result = Math.min(result, 1 + next);
                    }
                }
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
        }
        return result;
    }


    private String vanish(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && ch != sb.charAt(sb.length() - 1)) {
                removeTail(sb);
            }
            sb.append(ch);
        }
        removeTail(sb);
        return sb.toString();
    }

    private void removeTail(StringBuilder sb) {
        int len = 0;
        char ch = sb.charAt(sb.length() - 1);
        for (int i = sb.length() - 1; i >= 0 && sb.charAt(i) == ch; i--) {
            len++;
        }
        if (len > 2) {
            sb.delete(sb.length() - len, sb.length());
        }
    }
}
