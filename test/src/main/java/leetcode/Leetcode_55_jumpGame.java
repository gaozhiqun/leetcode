package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_55_jumpGame {

    public static void main(String[] args) {

        Leetcode_55_jumpGame leetcode_55_jumpGame = new Leetcode_55_jumpGame();
        System.out.println(leetcode_55_jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(leetcode_55_jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(leetcode_55_jumpGame.canJump(new int[]{0}));
    }


    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                break;
            }
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}
