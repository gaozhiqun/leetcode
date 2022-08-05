package leetcode;

import java.util.Stack;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_855_ExamRoom {
    public static void main(String[] args) {
        Leetcode_855_ExamRoom l = new Leetcode_855_ExamRoom();

    }

    class ExamRoom {
        int N;
        TreeSet<Integer> students;

        public ExamRoom(int N) {
            this.N = N;
            students = new TreeSet();
        }

        public int seat() {
            int student = 0;
            if (students.size() > 0) {
                int dist = students.first();
                Integer prev = null;
                for (Integer s : students) {
                    if (prev != null) {
                        int d = (s - prev) / 2;
                        if (d > dist) {
                            dist = d;
                            student = prev + d;
                        }
                    }
                    prev = s;
                }
                if (N - 1 - students.last() > dist) {
                    student = N - 1;
                }
            }
            students.add(student);
            return student;
        }

        public void leave(int p) {
            students.remove(p);
        }
    }


}
