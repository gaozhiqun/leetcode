package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_850_rectangleArea {

    public static void main(String[] args) {
        Leetcode_850_rectangleArea l = new Leetcode_850_rectangleArea();
        System.out.println(l.rectangleArea(new int[][]{
                {0, 0, 2, 2}, {1, 1, 3, 3}
        }));

        System.out.println(l.rectangleArea(new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        }));

        System.out.println(l.rectangleArea(new int[][]{
                {0, 0, 1000000000, 1000000000}, {0, 0, 1000000000, 1000000000}
        }));
    }

    public int rectangleArea(int[][] rectangles) {
        int OPEN = 1, CLOSE = -1, N = rectangles.length;

        int[][] events = new int[N * 2][];
        Set<Integer> Xvals = new HashSet();
        int t = 0;
        for (int i = 0; i < N; i++) {
            int[] rec = rectangles[i];
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
            cur_x_sum = active.updateAndGet(Xi.get(x1), Xi.get(x2), typ);
            cur_y = y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }

    public static class Node {
        int l, r;
        Integer[] X;
        Node lchild, rchild;
        int count; //有效线段个数
        long total;// x坐标长度

        public Node(int start, int end, Integer[] X) {
            this.l = start;
            this.r = end;
            this.X = X;
            lchild = null;
            rchild = null;
            count = 0;
            total = 0;
        }

        public int getMid() {
            return l + (r - l) / 2;
        }

        public Node getLchild() {
            if (lchild == null) {
                lchild = new Node(l, getMid(), X);
            }
            return lchild;
        }

        public Node getRchild() {
            if (rchild == null) {
                rchild = new Node(getMid(), r, X);
            }
            return rchild;
        }

        public long updateAndGet(int l, int r, int val) {
            if (l >= r) {
                return total; //不是有效线段，不更新
            }
            if (this.l == l && this.r == r) {
                count += val;
            } else {
                getLchild().updateAndGet(l, Math.min(getMid(), r), val);
                getRchild().updateAndGet(Math.max(getMid(), l), r, val);
            }

            if (count > 0) {
                total = X[this.r] - X[this.l];// 不要写错了！
            } else {//没有完全覆盖此区间的
                total = getLchild().total + getRchild().total; //count==0
            }

            return total;
        }


    }
}