import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        System.out.println(merge(intervals, newInterval));
    }

    public static int[][] merge(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] cur = newInterval;
        for (int[] interval : intervals) {
            if (cur == null) {
                result.add(interval);
                continue;
            }
            if (interval[1] < cur[0]) {
                result.add(interval);
            } else if (interval[0] > cur[1]) {
                result.add(cur);
                result.add(interval);
                cur = null;
            } else {
                cur = merge(interval, cur);
            }
        }
        if (cur != null) {
            result.add(cur);
        }
        int[][] temp = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            temp[i][0] = result.get(i)[0];
            temp[i][1] = result.get(i)[1];
        }
        return temp;
    }

    private static int[] merge(int[] l, int[] r) {
        return new int[]{Math.min(l[0], r[0]), Math.max(l[1], r[1])};
    }
}
