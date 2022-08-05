package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午1:48
 */
public class ChampagneTower {
    /**
     * 香槟塔 799
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] array = new double[query_row + 1];
        array[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i - 1; j >= 0; --j) {
                double l = j - 1 > 0 && array[j - 1] > 1 ? (array[j - 1] - 1) / 2 : 0;
                double r = array[j] > 1 ? (array[j] - 1) / 2 : 0;
                array[j] = l + r;
            }
        }
        return Math.min(array[query_glass], 1.0);
    }


}
