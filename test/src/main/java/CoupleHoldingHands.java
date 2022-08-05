/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/19 5:40 下午
 */
public class CoupleHoldingHands {

    public static void main(String[] args) {
        CoupleHoldingHands coupleHoldingHands = new CoupleHoldingHands();
        //  System.out.println(coupleHoldingHands.minSwap(new int[]{1, 2, 3, 4}));
        System.out.println(coupleHoldingHands.minSwap(new int[]{0, 3, 2, 1}));

    }

    public int minSwap(int[] couples) {
        int result = 0;
        for (int i = 0; i < couples.length; i += 2) {
            if (isCouple(couples[i], couples[i + 1])) {
                continue;
            }
            int j = i + 2;
            while (!isCouple(couples[i], couples[j]) && j < couples.length) {
                j++;
            }
            swap(couples, i + 1, j);
            ++result;
        }
        return result;
    }


    public boolean isCouple(int l, int r) {
        return l / 2 == r / 2;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    int[] p = new int[70];
    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length, m = n / 2;
        for (int i = 0; i < m; i++) p[i] = i;
        for (int i = 0; i < n; i += 2) union(row[i] / 2, row[i + 1] / 2);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (i == find(i)) cnt++;
        }
        return m - cnt;
    }


}

