package algorithm.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午7:19
 */
public class MinRefuelStops {
    public static void main(String[] args) {

    }

    public int minRefuelStops(int target, int startFule, int[][] stations) {
        //加油站从今到远排序
        Arrays.sort(stations, (a, b) -> {
            return a[0] - b[0];
        });
        if (startFule >= target) {
            return 0;
        }
        Queue<CarStatus> queue = new LinkedList<>();
        queue.offer(new CarStatus(0, -1, startFule, 0));
        while (!queue.isEmpty()) {
            CarStatus carStatus = queue.poll();
            if (carStatus.cur + carStatus.fuelRemain >= target) {
                return carStatus.steps;
            }

            for (int next = carStatus.i + 1; next < stations.length && carStatus.cur + carStatus.fuelRemain >= stations[next][0]; ++next) {
                queue.offer(new CarStatus(stations[next][0], next,
                        carStatus.fuelRemain + carStatus.cur - stations[next][0] + stations[next][1], carStatus.steps + 1));
            }
        }


        return -1;

    }

    public static class CarStatus {
        int i; //第几座加油站
        int cur = 0;
        int fuelRemain;// 剩余油量
        int steps;

        public CarStatus(int cur, int i, int fuelRemain, int steps) {
            this.i = i;
            this.cur = cur;
            this.fuelRemain = fuelRemain;
            this.steps = steps;
        }
    }

}
