package segmentTree;

import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/29 上午10:04
 */
public class MyCalendarTwo {
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
    }

    /**
     * MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(50, 60); // returns true
     * MyCalendar.book(10, 40); // returns true
     * MyCalendar.book(5, 15); // returns false
     * MyCalendar.book(5, 10); // returns true
     * MyCalendar.book(25, 55); // returns true
     */

    TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        delta = new TreeMap();
    }

    /**
     * delta 表示当前正在进行的日程安排数
     */
    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1); //+1
        delta.put(end, delta.getOrDefault(end, 0) - 1); //-1

        int active = 0;
        for (int d : delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0) {
                    delta.remove(start);
                }
                return false;
            }
        }
        return true;
    }


}
