package algorithm.array;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/16 下午5:39
 */
public class SlidingPuzzle {
    public static void main(String[] args) {

    }

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    /**
     * board 2*3 数组
     * 6个状态
     *
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        PriorityQueue<AStar> pq = new PriorityQueue<AStar>((a, b) -> a.f - b.f);
        pq.offer(new AStar(initial, 0));
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!pq.isEmpty()) {
            AStar node = pq.poll();
            for (String nextStatus : get(node.status)) {
                if (!seen.contains(nextStatus)) {
                    if ("123450".equals(nextStatus)) {
                        return node.g + 1;
                    }
                    pq.offer(new AStar(nextStatus, node.g + 1));
                    seen.add(nextStatus);
                }
            }
        }

        return -1;

    }

    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public static class AStar {

        public static int[][] dist = {
                {0, 1, 2, 1, 2, 3},
                {1, 0, 1, 2, 1, 2},
                {2, 1, 0, 3, 2, 1},
                {1, 2, 3, 0, 1, 2},
                {2, 1, 2, 1, 0, 1},
                {3, 2, 1, 2, 1, 0}
        };
        String status;
        int f;
        int h;
        int g;

        public AStar(String status, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status);
            this.f = g + h;
        }

        private int getH(String status) {
            int ret = 0;
            for (int i = 0; i < 6; ++i) {
                if (status.charAt(i) != '0') {
                    ret += dist[i][status.charAt(i) - '1'];
                }
            }
            return ret;
        }
    }
}
