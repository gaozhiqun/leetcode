package segmentTree;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/29 上午11:47
 */
public class ReactAngleArea {
    public static void main(String[] args) {
        ReactAngleArea reactAngleArea = new ReactAngleArea();

        System.out.println(reactAngleArea.rectangleArea(new int[][]{
                {0, 0, 2, 2}, {1, 1, 3, 3}
        }));

        System.out.println(reactAngleArea.rectangleArea(new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        }));

        System.out.println(reactAngleArea.rectangleArea(new int[][]{
                {0, 0, 1000000000, 1000000000}, {0, 0, 1000000000, 1000000000}
        }));

    }


    public int rectangleArea(int[][] rectangles) {
        int OPEN = 1, CLOSE = -1;
        int[][] events = new int[rectangles.length * 2][];
        Set<Integer> Xvals = new HashSet();
        int t = 0;
        for (int[] rec : rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};//(cur_y,type, l, r)
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
            Xvals.add(rec[0]);
            Xvals.add(rec[2]);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        //扫描线按照纵坐标，递增排序

        Integer[] X = Xvals.toArray(new Integer[0]);
        Arrays.sort(X);
        Map<Integer, Integer> Xi = new HashMap();
        for (int i = 0; i < X.length; ++i) {
            Xi.put(X[i], i);
        }
        //离散化 X坐标

        Node active = new Node(0, X.length - 1, X);
        long ans = 0;
        long cur_x_sum = 0;
        int cur_y = events[0][0];

        for (int[] event : events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            ans += cur_x_sum * (y - cur_y);
            cur_x_sum = active.update(Xi.get(x1), Xi.get(x2), typ);
            cur_y = y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }
}

class Node {
    int start, end;
    Integer[] X;
    Node left, right;
    int count; //有效线段个数
    long total;// x坐标长度

    public Node(int start, int end, Integer[] X) {
        this.start = start;
        this.end = end;
        this.X = X;
        left = null;
        right = null;
        count = 0;
        total = 0;
    }

    public int getRangeMid() {
        return start + (end - start) / 2;
    }

    public Node getLeft() {
        if (left == null) {
            left = new Node(start, getRangeMid(), X);
        }
        return left;
    }

    public Node getRight() {
        if (right == null) {
            right = new Node(getRangeMid(), end, X);
        }
        return right;
    }

    public long update(int i, int j, int val) {
        if (i >= j) {
            return total; //不是有效线段，不更新
        }
        if (start == i && end == j) {
            count += val;
        } else {
            getLeft().update(i, Math.min(getRangeMid(), j), val);
            getRight().update(Math.max(getRangeMid(), i), j, val);
        }

        if (count > 0) {
            total = X[end] - X[start];
        } else {//没有完全覆盖此区间的
            total = getLeft().total + getRight().total; //count==0
        }

        return total;
    }

}
