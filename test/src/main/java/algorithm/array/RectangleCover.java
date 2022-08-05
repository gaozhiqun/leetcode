package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午7:37
 */
public class RectangleCover {
    public static void main(String[] args) {

    }

    public boolean isRectangleCover(int[][] rectAngles) {
        int l = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int t = Integer.MIN_VALUE;
        for (int[] rectangles : rectAngles) {
            l = Math.min(rectangles[0], l);
            b = Math.min(rectangles[1], b);
            r = Math.max(rectangles[2], r);
            t = Math.max(rectangles[3], t);
        }
        for (int[] rectangles : rectAngles) {
            rectangles[0] -= l;
            rectangles[1] -= b;
            rectangles[2] -= l;
            rectangles[3] -= b;
        }
        return false;


    }
}
