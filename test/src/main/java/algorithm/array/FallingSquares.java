package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/2 下午8:10
 */
public class FallingSquares {
    public static void main(String[] args) {

    }

    public static class SegNode {
        int left, right;
        boolean cover;
        int count;
        SegNode l;
        SegNode r;

        SegNode(int left, int right) {
            this.left = left;
            this.right = right;
            cover = false;
            count = 0;
        }
    }


}
