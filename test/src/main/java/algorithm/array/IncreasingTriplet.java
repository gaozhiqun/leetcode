package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/29 上午10:57
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }


}
