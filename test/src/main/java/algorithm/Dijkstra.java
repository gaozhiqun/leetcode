package algorithm;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/1/14 8:44 下午
 */
public class Dijkstra {

    public void solution(int[][] weight, int start) {
        boolean[] visit = new boolean[weight.length];
        int[] res = new int[weight.length];     // 记录 start 点到各点的最短路径长度

        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        for (int i = 0; i < weight.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            for (int j = 0; j < weight.length; j++) {
                if (j != start && !visit[j] && res[j] < min) {
                    min = res[j];
                    p = j;
                }
            }
            visit[p] = true;
            for (int j = 0; j < weight.length; j++) {
                if (j == p || weight[p][j] == Integer.MAX_VALUE) {  // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]) {
                    res[j] = res[p] + weight[p][j];  //更新最短路径
                }
            }
        }
    }
}
