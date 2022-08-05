package algorithm.string;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午4:41
 */
public class ShortestPathAllKeys {
    public static void main(String[] args) {

    }

    Set<Character> keys = new HashSet<>();
    Map<String, Integer> dist = new HashMap<>();
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int keysTotal = 0;
        int si = 0, sj = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    si = i;
                    sj = j;
                } else if (ch >= 'a' && ch < 'z') {
                    ++keysTotal;
                }
            }
        }
        Deque<int[]> moves = new LinkedList<>();
        moves.push(new int[]{si, sj});
        while (!moves.isEmpty()) {


        }
        return -1;
    }

    /**
     * 状态压缩
     *
     * @param i
     * @param j
     * @return
     */
    private List<String> nextMoves(int i, int j, String path) {
        List<String> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int di = i + dir[0], dj = j + dir[1];
        }
        return neighbors;
    }


}
