package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_307_NumArray {

    /**
     * 树状数组详解
     * 给你一个数组 nums ，请你完成两类查询。
     * <p>
     * 其中一类查询要求 更新 数组 nums 下标对应的值
     * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
     * 实现 NumArray 类：
     * <p>
     * NumArray(int[] nums) 用整数数组 nums 初始化对象
     * void update(int index, int val) 将 nums[index] 的值 更新 为 val
     * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
     *
     * @param args
     */

    public static void main(String[] args) {

    }

    public static class NumArray {
        private int n;
        private int[] tree;


        public NumArray(int[] nums) {
            this.n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }


        private void buildTree(int[] nums) {
            for (int i = n, j = 0; i < 2 * n; i++, j++) {
                tree[i] = nums[j];
            }
            for (int i = n - 1; i > 0; --i) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }


        public void update(int pos, int val) {
            pos += n;
            tree[pos] = val;
            while (pos > 0) {
                int left = pos;
                int right = pos;
                if (pos % 2 == 0) {
                    right = pos + 1;
                } else {
                    left = pos - 1;
                }
                // parent is updated after child is updated
                tree[pos / 2] = tree[left] + tree[right];
                pos /= 2;

            }
        }

        public int sumRange(int l, int r) {
            // get leaf with value 'l'
            l += n;
            // get leaf with value 'r'
            r += n;
            int sum = 0;
            while (l <= r) {
                //右侧左节点
                if ((l % 2) == 1) {
                    sum += tree[l];
                    l++;
                }
                //左侧右节点
                if ((r % 2) == 0) {
                    sum += tree[r];
                    r--;
                }
                //上一层
                l /= 2;
                r /= 2;
            }
            return sum;
        }

    }
}