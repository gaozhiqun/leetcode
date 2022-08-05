import algorithm.ListNodeMap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StreamMedium {
    public static void main(String[] args) {
        StreamMedium streamMedium = new StreamMedium();
        streamMedium.addNum(0);
        System.out.println(streamMedium.findMedian());
        streamMedium.addNum(1);
        System.out.println(streamMedium.findMedian());

        streamMedium.addNum(2);
        System.out.println(streamMedium.findMedian());

        streamMedium.addNum(3);
        System.out.println(streamMedium.findMedian());

        streamMedium.addNum(4);
        System.out.println(streamMedium.findMedian());

    }

    private Queue<Integer> lQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    });

    private Queue<Integer> rQueue = new PriorityQueue<>();

    public void addNum(int num) {
        if (lQueue.isEmpty()) {
            lQueue.add(num);
            return;
        }
        if (num > lQueue.peek()) {
            rQueue.add(num);
            if (rQueue.size() > lQueue.size()) {
                lQueue.add(rQueue.poll());
            }

        } else {
            lQueue.add(num);
            if (lQueue.size() - rQueue.size() > 1) {
                rQueue.add(lQueue.poll());
            }
        }
    }

    public double findMedian() {

        if (lQueue.isEmpty()) {
            return 0;
        }
        if ((lQueue.size() + rQueue.size()) % 2 == 0) {
            return ((double) (lQueue.peek() + rQueue.peek())) / 2;
        }
        return lQueue.peek();
    }

}
