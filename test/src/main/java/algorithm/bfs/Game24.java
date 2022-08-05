package algorithm.bfs;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/2 下午1:32
 */
public class Game24 {
    public static void main(String[] args) {
        Game24 game24 = new Game24();
        System.out.println(game24.judgePoint24(new int[]{4, 1, 8, 7}));
    }

    public boolean judgePoint24(int[] cards) {
        return dfs(0, 0, 0, cards);
    }

    public boolean dfs(int cur, int result, int accumulate, int[] cards) {
        if (cur >= cards.length) {
            return result == 24;
        }
        //+
        boolean tempResult = false;
        int num = cards[cur];
        tempResult = tempResult || dfs(cur + 1, result, accumulate + num, cards);
        tempResult = tempResult || dfs(cur + 1, result, accumulate - num, cards);
        tempResult = tempResult || dfs(cur + 1, result, accumulate * num, cards);
        if (num != 0) {
            tempResult = tempResult || dfs(cur + 1, result, accumulate / num, cards);
        }
        tempResult = tempResult || dfs(cur + 1, result + accumulate, num, cards);
        tempResult = tempResult || dfs(cur + 1, result - accumulate, num, cards);
        tempResult = tempResult || dfs(cur + 1, result * accumulate, num, cards);
        if (accumulate != 0) {
            tempResult = tempResult || dfs(cur + 1, result / accumulate, num, cards);
        }
        return tempResult;
    }
}
