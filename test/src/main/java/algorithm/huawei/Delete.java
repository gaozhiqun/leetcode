package algorithm.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/2 下午3:02
 */
public class Delete {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split("\\s");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        int cnt = Integer.parseInt(scanner.nextLine());
        if (m == 0 || n == 0) {
            System.out.println("0");
        }
        int[][] basements = new int[cnt][3];
        boolean[][] base = new boolean[m][n];
        for (int i = 0; i < basements.length; ++i) {
            line = scanner.nextLine();
            parts = line.split("\\s");
            basements[i] = new int[3];
            basements[i][0] = Integer.parseInt(parts[0]) - 1;
            basements[i][1] = Integer.parseInt(parts[1]) - 1;
            basements[i][2] = 1;
        }
        ops(base, m, n, basements);
        int opC = Integer.parseInt(scanner.nextLine());
        int[][] ops = new int[opC][3];
        for (int i = 0; i < opC; ++i) {
            line = scanner.nextLine();
            parts = line.split("\\s");
            ops[i][0] = Integer.parseInt(parts[1])-1;
            ops[i][1] = Integer.parseInt(parts[2])-1;
            if ("delete".equals(parts[0])) {
                ops[i][2] = 0;
            } else {
                ops[i][2] = 1;
            }
        }
        ops(base, m, n, ops);
        System.out.println(calculateSum(base, m, n));
    }


    public static void ops(boolean[][] base, int m, int n, int[][] ops) {
        for (int[] op : ops) {
            int i = op[0], j = op[1], opC;
            if (op[2] == 0) {//delete
                for (int v = -1; v <= 1; ++v) {
                    for (int h = -1; h <= 1; ++h) {
                        int ni = i + v, nj = j + h;
                        if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                            continue;
                        }
                        if (base[ni][nj]) {
                            base[ni][nj] = false;
                        }
                    }
                }
            } else {
                base[i][j] = true;
            }
        }
    }

    public static int calculateSum(boolean[][] base, int m, int n) {
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!base[i][j]) {
                    continue;
                }
                for (int v = -1; v <= 1; ++v) {
                    for (int h = -1; h <= 1; ++h) {
                        int ni = i + v, nj = j + h;
                        if (ni < 0 || nj < 0 || ni >= m || nj >= n || base[ni][nj]) {
                            continue;
                        }
                        ++ret;
                    }
                }
            }
        }
        return ret;
    }
}
