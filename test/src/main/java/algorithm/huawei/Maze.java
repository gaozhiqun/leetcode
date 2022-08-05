package algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午1:43
 */
public class Maze {

    public static void main(String[] args) {
        /**
         * 0 1 0 0 0
         * 0 1 1 1 0
         * 0 0 0 0 0
         * 0 1 1 1 0
         * 0 0 0 1 0
         */
        //int[][] maze = new int[][]{{0, 1, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}};
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();//个数
            int n = in.nextInt();//个数
            int[][] maze = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = in.nextInt();//砝码个数
                }
            }
            List<int[]> ret = travel(maze);
            for (int[] pair : ret) {
                System.out.println(String.format("(%s,%s)", pair[0], pair[1]));
            }
        }


    }


    public static List<int[]> travel(int[][] mat) {
        LinkedList<int[]> linkedList = new LinkedList<>();
        if (mat[0][0] != 0) {
            return linkedList;
        }
        bfs(0, 0, linkedList, mat);
        return linkedList;
    }

    private static boolean bfs(int i, int j, LinkedList<int[]> path, int[][] mat) {
        path.addLast(new int[]{i, j});
        mat[i][j] = -1;
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return true;
        }
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; ++d) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];
            if (ni < 0 || nj < 0 || ni >= mat.length || nj >= mat[0].length || mat[ni][nj] != 0) {
                continue;
            }
            if (bfs(ni, nj, path, mat)) {
                return true;
            }
        }
        path.pollLast();
        mat[i][j] = 0;
        return false;
    }

}
