package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_27_removeElement {

    public static void main(String[] args) {
        Leetcode_27_removeElement l = new Leetcode_27_removeElement();
        System.out.println(l.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int idx = 0, ans = 0;
        for (int i : nums) {
            if (i == val) {
                continue;
            }
            nums[idx++] = i;
            ++ans;
        }
        return ans;
    }

}

