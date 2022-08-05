package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/3 2:31 下午
 */
public class ExistsWord {
    public static void main(String[] args) {

        ExistsWord existsWord = new ExistsWord();
        System.out.println(existsWord.exists(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exists(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (bfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, boolean[][] visited, int i, int j, int cur, String word) {
        if (cur >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = false;
        for (int[] dir : dirs) {
            result = result || bfs(board, visited, i + dir[0], j + dir[1], cur + 1, word);
        }
        visited[i][j] = false;
        return result;
    }
}
