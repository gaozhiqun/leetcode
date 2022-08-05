package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/14 下午7:55
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        NumRescueBoats numRescueBoats = new NumRescueBoats();
        System.out.println(numRescueBoats.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                ++l;
                --r;
            } else {
                --r;
            }
            ans++;
        }
        return ans;
    }
}
