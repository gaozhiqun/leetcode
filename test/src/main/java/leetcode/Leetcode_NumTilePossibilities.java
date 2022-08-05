package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午8:20
 */
public class Leetcode_NumTilePossibilities {

    public static void main(String[] args) {
        Leetcode_NumTilePossibilities l = new Leetcode_NumTilePossibilities();
        System.out.println(l.numTilePossibilities("ABB"));
        System.out.println(l.numTilePossibilities("AAABBC"));

    }


    int ret;

    public int numTilePossibilities(String tiles) {
        int[] cnts = new int[26];
        ret = 0;
        for (char ch : tiles.toCharArray()) {
            cnts[ch - 'A']++;
        }
        dfs(cnts);
        return ret;
    }

    private void dfs(int[] cnts) {
        for (int i = 0; i < cnts.length; ++i) {
            if (cnts[i] > 0) {
                ++ret;
                cnts[i]--;
                dfs(cnts);
                cnts[i]++;
            }
        }
    }

}
