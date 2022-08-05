package segmentTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/30 下午5:16
 */
public class ClosetToTarget {

    public static void main(String[] args) {
        ClosetToTarget closetToTarget = new ClosetToTarget();
        System.out.println(closetToTarget.closestToTarget(
                new int[]{9, 12, 3, 7, 15}, 5));
        System.out.println(closetToTarget.closestToTarget2(
                new int[]{9, 12, 3, 7, 15}, 5));
    }

    //brutal
    public int closestToTarget(int[] arr, int target) {
        List<Integer> temp = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        for (int n : arr) {
            List<Integer> tempNew = new ArrayList<>();
            tempNew.add(n);
            int last = n;
            ans = Math.min(ans, Math.abs(n - target));
            for (int pre : temp) {
                int curr = pre & n;
                if (curr == last) {
                    continue;
                }
                ans = Math.min(ans, Math.abs(curr - target));
                tempNew.add(curr);
            }
            temp = tempNew;
        }
        return ans;
    }

    public int closestToTarget2(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        List<Integer> valid = new ArrayList<Integer>();
        valid.add(arr[0]);
        for (int num : arr) {
            List<Integer> validNew = new ArrayList<Integer>();
            validNew.add(num);
            int last = num;
            ans = Math.min(ans, Math.abs(num - target));
            for (int prev : valid) {
                int curr = prev & num;
                if (curr != last) {
                    validNew.add(curr);
                    ans = Math.min(ans, Math.abs(curr - target));
                    last = curr;
                }
            }
            valid = validNew;
        }
        return ans;
    }


}
