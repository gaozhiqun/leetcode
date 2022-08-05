package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_622_MyCircularQueue {

    public static void main(String[] args) {
        Leetcode_622_MyCircularQueue l = new Leetcode_622_MyCircularQueue();

    }

    public static class MyCircularQueue {

        private int[] array;
        private int capacity;
        private int head;
        private int tail;
        private int size;

        public MyCircularQueue(int k) {
            array = new int[k];
            capacity = k;
            tail = -1;
            head = size = 0;

        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % capacity;
            size++;
            array[tail] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            --size;
            return true;
        }

        public int Front() {
            if (size == 0) {
                return -1;
            }
            return array[head];
        }

        public int Rear() {
            if (size == 0) {
                return -1;
            }
            return array[tail];

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }


}