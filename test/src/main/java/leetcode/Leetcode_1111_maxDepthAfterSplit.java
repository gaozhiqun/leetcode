package leetcode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午2:46
 */

public class Leetcode_1111_maxDepthAfterSplit {

    public static void main(String[] args) {
        Leetcode_1111_maxDepthAfterSplit l = new Leetcode_1111_maxDepthAfterSplit();
        int[] ret = l.maxDepthAfterSplit("()(())()");
        for (int i : ret) {
            System.out.println(i);
        }
    }


    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> stack = new Stack<>();
        int m = seq.length();
        int[] ret = new int[m];
        int bc = 0;
        for (int i = 0; i < seq.length(); ++i) {
            char c = seq.charAt(i);
            if ('(' == c) {
                ++bc;
                stack.push(i);
            } else {
                int pre = stack.pop();
                if (bc % 2 == 0) {
                    ret[pre] = 1;
                    ret[i] = 1;
                } else {
                    ret[pre] = 0;
                    ret[i] = 0;
                }
                --bc;
            }
        }
        return ret;

    }

}
