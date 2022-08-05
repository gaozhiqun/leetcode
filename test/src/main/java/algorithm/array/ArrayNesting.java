package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午5:09
 */
public class ArrayNesting {
    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        System.out.println(arrayNesting.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public int arrayNesting(int[] nums) {
        int m = nums.length;
        int result = -1;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0, cur = i;
            while (!visited[cur]) {
                visited[cur] = true;
                ++temp;
                cur = nums[cur];
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
