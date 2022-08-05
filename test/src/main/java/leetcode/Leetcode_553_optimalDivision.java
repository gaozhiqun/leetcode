package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_553_optimalDivision {


    public static void main(String[] args) {
        Leetcode_553_optimalDivision l = new Leetcode_553_optimalDivision();
        System.out.println(l.optimalDivision(new int[]{1000, 100, 10, 2}));
    }


    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            StringBuilder ans = new StringBuilder(String.valueOf(nums[0]));
            ans.append("/");
            ans.append(nums[1]);
            return ans.toString();
        }
        StringBuilder ans = new StringBuilder();
        ans.append(nums[0]);
        ans.append("/");
        ans.append("(");
        for (int i = 1; i < nums.length; i++) {
            ans.append(nums[i]);
            ans.append("/");
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append(")");
        return ans.toString();
    }


}