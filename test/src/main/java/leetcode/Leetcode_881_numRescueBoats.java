package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_881_numRescueBoats {
    public static void main(String[] args) {
        Leetcode_881_numRescueBoats l = new Leetcode_881_numRescueBoats();
        System.out.println(l.numRescueBoats(new int[]{3, 4, 3, 5}, 5));
        System.out.println(l.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(l.numRescueBoats(new int[]{3, 2, 2, 1}, 3));


    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int ret = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                ++l;
            }
            --r;
            ++ret;
        }
        return ret;
    }


}
