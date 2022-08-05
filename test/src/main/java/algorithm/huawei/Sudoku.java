package algorithm.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午11:24
 */
public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] boards = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; ++i) {
            String line = scanner.nextLine();
            String[] digits = line.split(" ");
            for (int j = 0; j < 9; ++j) {
                boards[i][j] = Integer.parseInt(digits[j]);
            }
        }
        sudoku.solveSudoku(boards);
        for (int i = 0; i < 9; ++i) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : boards[i]) {
                stringBuilder.append(num);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
        }
    }


    public void solveSudoku(int[][] board) {
        boolean[][] verticals = new boolean[9][9];
        boolean[][] horizontals = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        int m = board.length, n = board[0].length;
        LinkedList<int[]> todoList = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = getDigNum(i, j);
                int digit = board[i][j];
                if (digit == 0) {
                    todoList.addLast(new int[]{i, j});
                    continue;
                }
                int num = digit - 1;
                verticals[i][num] = true;
                horizontals[j][num] = true;
                blocks[k][num] = true;
            }
        }
        bfs(board, todoList, verticals, horizontals, blocks);
    }

    private boolean bfs(int[][] board, LinkedList<int[]> todoList,
                        boolean[][] vertical, boolean[][] horizontal, boolean[][] dignals) {
        if (todoList.isEmpty()) {
            return true;
        }
        int[] next = todoList.pollFirst();
        int i = next[0], j = next[1], k = getDigNum(i, j);
        for (int n = 0; n < 9; n++) {
            if (!vertical[i][n] && !horizontal[j][n] && !dignals[k][n]) {
                board[i][j] = n + 1;
                vertical[i][n] = true;
                horizontal[j][n] = true;
                dignals[k][n] = true;
                boolean done = bfs(board, todoList, vertical, horizontal, dignals);
                if (done) {
                    return true;
                }
                board[i][j] = 0;
                vertical[i][n] = false;
                horizontal[j][n] = false;
                dignals[k][n] = false;
            }
        }
        todoList.addFirst(new int[]{i, j});
        return false;
    }

    private int getDigNum(int i, int j) {
        return 3 * (i / 3) + j / 3;
    }
}