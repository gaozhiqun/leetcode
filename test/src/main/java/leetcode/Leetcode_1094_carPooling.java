package leetcode;/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 上午12:06
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_1094_carPooling {
    public static void main(String[] args) {
        Leetcode_1094_carPooling l = new Leetcode_1094_carPooling();
        System.out.println(l.carPooling(new int[][]{
                {2, 1, 5}, {3, 3, 7}
        }, 5));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int remain = capacity;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                return b[0] - a[0];
            }
            return a[2] - b[2]; //按照事件结束事件排序
        });
        for (int[] trip : trips) {
            priorityQueue.offer(new int[]{0, trip[0], trip[1]});//上车事件
            priorityQueue.offer(new int[]{1, trip[0], trip[2]});//下车事件
        }
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            if (cur[0] == 0) {
                if (remain < cur[1]) {
                    break;
                } else {
                    remain -= cur[1];
                }
            } else {
                remain += cur[1];
            }
        }
        return priorityQueue.isEmpty();

    }
}
