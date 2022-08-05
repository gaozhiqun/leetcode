package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_331_isValidSerialization {
    public static void main(String[] args) {
        /**
         * [1,2,31,33]
         * 2147483647
         */
        Leetcode_331_isValidSerialization l = new Leetcode_331_isValidSerialization();
        System.out.println(l.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

    }

    /**
     * _9_
     * /   \
     * 3     2
     * / \   / \
     * 4   1  #  6
     * / \ / \   / \
     * # # # #   # #
     * "9,3,4,#,#,1,#,#,2,#,6,#,#"
     * <p>
     * NLR
     */

    public boolean isValidSerialization(String preorder) {
        int slot = 1;
        String[] orders = preorder.split(",");
        for (String order : orders) {
            if (slot <= 0) {
                return false;
            }
            if ("#".equals(order)) {
                --slot;
            } else {
                ++slot;
            }
        }
        return slot == 0;
    }

}
