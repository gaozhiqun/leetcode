package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_853_carFleet {
    public static void main(String[] args) {
        Leetcode_853_carFleet l = new Leetcode_853_carFleet();
        System.out.println(l.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));

    }

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        int[][] array = new int[N][2];
        for (int i = 0; i < N; ++i) {
            array[i][0] = position[i];
            array[i][1] = speed[i];
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || ((target - stack.peek()[0]) * array[i][1]
                    - (target - array[i][0]) * stack.peek()[1] < 0)) {
                stack.push(array[i]);
            }
        }
        return stack.size();


    }


}
