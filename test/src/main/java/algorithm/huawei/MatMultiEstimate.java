package algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 上午10:36
 */
public class MatMultiEstimate {


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = Integer.parseInt(in.nextLine());
//        int[][] mat = new int[m][2];
//        for (int i = 0; i < m; ++i) {
//            String line = in.nextLine();
//            mat[i][0] = Integer.parseInt(line.split(" ")[0]);
//            mat[i][1] = Integer.parseInt(line.split(" ")[1]);
//        }
//        String expr = in.nextLine();
        MatMultiEstimate matMultiEstimate = new MatMultiEstimate();
//        System.out.println(matMultiEstimate.estimate(m, mat, expr));
        /**
         * 23 61
         * 61 59
         * 59 34
         * 34 56
         * 56 35
         */
        System.out.println(matMultiEstimate.estimate(5, new int[][]{
                {23, 61}, {61, 59}, {59, 34}, {34, 56}, {56, 35}
        }, "(A(((BC)D)E))"));
    }

    long ret;

    public long estimate(int m, int[][] mat, String expr) {
        ret = 0;
        Stack<Character> exStack = new Stack<>();
        Stack<int[]> valStack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == ')') {
                exStack.pop();
                exStack.pop();
                calStack(valStack);
            } else if (ch!='('){
                exStack.push(ch);
                valStack.push(mat[(ch - 'A')]);
            }
        }
        while (!exStack.isEmpty()) {
            exStack.pop();
            calStack(valStack);
        }
        return ret;
    }


    private void calStack(Stack<int[]> stack) {
        if (stack.size() < 2) {
            return;
        }
        int[] b = stack.pop();
        int[] a = stack.pop();
        ret += (a[0] * a[1] * b[1]);
        int[] m = new int[]{a[0], b[1]};
        stack.push(m);
    }
}
