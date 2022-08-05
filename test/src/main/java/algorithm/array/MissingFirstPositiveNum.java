package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/29 3:07 下午
 */
public class MissingFirstPositiveNum {
    /**
     * 缺失的第一个正数
     */
    public int firstMissingNum(int[] array) {
        int nums = array.length;
        boolean[] result = new boolean[nums];
        for (int i : array) {
            if (i < nums) {
                result[i] = true;
            }
        }
        for (int i = 0; i < nums; i++) {
            if (!result[i]) {
                return i;
            }
        }
        return nums;
    }
}
