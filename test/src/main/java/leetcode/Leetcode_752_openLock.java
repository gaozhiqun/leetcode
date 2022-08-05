package leetcode;

import algorithm.array.SlidingPuzzle;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_752_openLock {

    public static void main(String[] args) {
        Leetcode_752_openLock l = new Leetcode_752_openLock();
    }

    /**
     * 任何一个元素相同 锁定
     *
     * @param deadends
     * @param target
     * @return
     */


    public int openLock(String[] deadends, String target) {
        Set<String> blackList = new HashSet<>();
        blackList.addAll(Arrays.asList(deadends));
        PriorityQueue<Astar> pq = new PriorityQueue<Astar>((a, b) -> a.f - b.f);
        pq.offer(new Astar("0000", target, 0));
        Set<String> seen = new HashSet<String>();
        seen.add("0000");
        while (!pq.isEmpty()) {
            Astar node = pq.poll();
            for (String nextStatus : getNbs(node.status)) {
                if (blackList.contains(node.status)) {
                    continue;
                }
                if (!seen.contains(nextStatus)) {
                    if (target.equals(nextStatus)) {
                        return node.g + 1;
                    }
                    pq.offer(new Astar(nextStatus, target, node.g + 1));
                    seen.add(nextStatus);
                }
            }
        }
        return -1;
    }

    public static class Astar {
        int h, f, g;
        String status;
        String target;

        public Astar(String status, String target, int g) {
            this.status = status;
            this.target = target;
            this.g = g;
            this.h = getH(status, target);
            this.f = g + h;
        }

        private int getH(String status, String target) {
            int ret = 0;
            for (int i = 0; i < status.length(); i++) {
                ret += Math.abs(status.charAt(i) - target.charAt(i)) % 10;
            }
            return ret;
        }
    }

    private List<String> getNbs(String status) {
        List<String> list = new ArrayList<>();
        char[] next = status.toCharArray();
        for (int i = 0; i < status.length(); i++) {
            char ch = next[i];
            next[i] = (char) ((ch - '0' + 1) % 10 + '0');
            list.add(new String(next));
            next[i] = (char) ((ch - '0' - 1) % 10 + '0');
            list.add(new String(next));
            next[i] = ch;
        }
        return list;
    }
}