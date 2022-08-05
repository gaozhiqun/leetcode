package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午5:24
 */
public class Leetcode_11_MaxArea {

    public static void main(String[] args) {
        Leetcode_11_MaxArea l = new Leetcode_11_MaxArea();
        System.out.println(l.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(l.maxArea(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans,
                    (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
