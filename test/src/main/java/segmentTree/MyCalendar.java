package segmentTree;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/29 上午10:04
 */
public class MyCalendar {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }

    TreeMap<Integer, Integer> calendar;


    public MyCalendar() {
        this.calendar = new TreeMap<>();

    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }


    public static class Interval implements Comparable<Interval> {
        public int l;
        public int r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.l == o.l) {
                return this.r - o.r;
            }
            return this.l - o.l;
        }
    }


}
