package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_169_majorityElement {

    public static void main(String[] args) {
        Leetcode_169_majorityElement l = new Leetcode_169_majorityElement();
        System.out.println(l.majorityElement(new int[]{3, 2, 3}));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int cnt = 0, ans = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (cnt == 0) {
                ans = nums[i];
                ++cnt;
            } else {
                if (nums[i] == ans) {
                    ++cnt;
                } else {
                    --cnt;
                }
            }
        }
        return ans;
    }


}