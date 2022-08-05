package algorithm.offer;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/28 下午9:14
 */
public class VerifyPreOrder {
    public static void main(String[] args) {
        VerifyPreOrder verifyPreOrder = new VerifyPreOrder();
        System.out.println(verifyPreOrder.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public boolean isValidSerialization(String preOrder) {
        int cur = 0;
        int slot = 1;
        while (cur < preOrder.length()) {
            if (slot == 0) {
                return false;
            }
            if (preOrder.charAt(cur) == ',') {
                cur++;
            } else if (preOrder.charAt(cur) == '#') {
                slot--;
                cur++;
            } else {
                while (cur < preOrder.length() && preOrder.charAt(cur) != ',') {
                    cur++;
                }
                slot++;
            }
        }
        return slot == 0;
    }
}
