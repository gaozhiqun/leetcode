package algorithm.tree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/15 9:33 下午
 */
public class ValidateTreePreOrder {
    //N L R

    public boolean validateTree(String array) {
        int n = array.length();
        int slot = 1;
        int cur = 0;
        while (cur < n) {
            if (slot == 0) {
                return false;
            }
            if (array.charAt(cur) == ',') {
                cur++;
            } else if (array.charAt(cur) == '#') {
                slot--;
                cur++;
            } else {
                while (array.charAt(cur) != ',') {
                    cur++;
                }
                slot++;
            }
        }
        return slot == 0;
    }

}
