package segmentTree;

import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/29 上午10:04
 */
public class MyCalendarThree {
    public static void main(String[] args) {
        MyCalendarThree myCalendar = new MyCalendarThree();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
    }

    /**
     * 边界计数法
     */
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

    public MyCalendarThree() {
        delta = new TreeMap();
    }

    /**
     * delta 表示当前正在进行的日程安排数
     */
    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1); //+1
        delta.put(end, delta.getOrDefault(end, 0) - 1); //-1

        int active = 0, ans = 0;
        for (int d : delta.values()) {
            active += d;
            if (active > ans) {
                ans = active;
            }
        }
        return ans;
    }


}
