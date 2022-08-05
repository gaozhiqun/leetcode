package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/8 下午2:49
 */
public class NumFriendRequests {
    public static void main(String[] args) {

    }

    /**
     * age[B] <=0.5*age[A] +7
     * age[B]>age[A];
     * age[B]>100 && age[A]<100
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for (int age : ages) {
            counts[age]++;
        }
        int result = 0;
        for (int age = 0; age <= 120; ++age) {
            int countA = counts[age];
        }
        return result;
    }

}
