package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 下午4:47
 */
public class ReachPoint {
    public static void main(String[] args) {

    }

    public boolean reachPoint(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx > ty) {
                tx -= ty;
            } else {
                ty -= tx;
            }
        }
        return false;
    }
}
