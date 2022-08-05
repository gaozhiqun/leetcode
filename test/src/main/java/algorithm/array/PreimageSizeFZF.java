package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/18 下午2:21
 */
public class PreimageSizeFZF {
    public static void main(String[] args) {
        PreimageSizeFZF preimageSizeFZF = new PreimageSizeFZF();
        System.out.println(preimageSizeFZF.preimageSizeFZF(0));
        System.out.println(preimageSizeFZF.preimageSizeFZF(5));
    }

    public int preimageSizeFZF(int k) {
        int init = 0;
        int counter = 0;
        while (counter < k) {
            init += 5;
            int temp = init;
            while (temp > 0) {
                ++counter;
                temp /= 5;
            }
        }
        if (counter == k) {
            return 5;
        }
        return 0;
    }

}
