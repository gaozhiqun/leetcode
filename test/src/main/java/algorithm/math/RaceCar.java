package algorithm.math;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/28 下午5:04
 */
public class RaceCar {
    public static void main(String[] args) {
        RaceCar raceCar = new RaceCar();
        System.out.println(raceCar.racecar(3));
        System.out.println(raceCar.racecar(6));
    }

    /**
     * 818
     *
     * @param target
     * @return A: pos+=speed,speed*=2;
     * R: speed>0, speed=-1: speed=1;
     */
    public int racecar(int target) {
        int result = Integer.MAX_VALUE;
        Queue<ReachPoint> queue = new PriorityQueue<>(new Comparator<ReachPoint>() {
            @Override
            public int compare(ReachPoint o1, ReachPoint o2) {
                return o1.moves - o2.moves;
            }
        });
        queue.offer(new ReachPoint(0, 1, 0));
        while (!queue.isEmpty()) {
            ReachPoint next = queue.poll();
            if (next.moves >= result) {
                continue;
            }
            if (next.pos == target) {
                result = Math.min(next.moves, result);
            } else if (next.speed < 0 && next.pos + target > 0) {
                queue.offer(new ReachPoint(next.pos - next.speed, 1, next.moves + 1));
            } else {
                queue.offer(new ReachPoint(next.pos, -1, next.moves));
                if (next.pos + next.speed <= target + 1) {
                    queue.offer(new ReachPoint(next.pos + next.speed, 2 * next.speed, next.moves + 1));
                }
            }
        }
        return result;
    }

    public static class ReachPoint {
        int pos;
        int speed;
        int moves;

        public ReachPoint(int pos, int speed, int moves) {
            this.pos = pos;
            this.speed = speed;
            this.moves = moves;
        }
    }
}
