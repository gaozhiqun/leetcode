package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午4:33
 */
public class SuperWashMachine {
    public static void main(String[] args) {
        SuperWashMachine superWashMachine = new SuperWashMachine();
        System.out.println(superWashMachine.findMinMoves(new int[]{0, 3, 0}));
    }

    public int findMinMoves(int[] machines) {
        int m = machines.length;
        int sum = 0;
        for (int i : machines) {
            sum += i;
        }
        if (sum % m != 0) {
            return -1;
        }
        int target = sum / m;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= target;
        }
        int curSum = 0, maxSum = 0, tempRes, result = 0;
        for (int i : machines) {
            curSum += i;
            maxSum = Math.max(maxSum, Math.abs(curSum));
            tempRes = Math.max(maxSum, i);
            result = Math.max(tempRes, result);
        }
        return result;
    }

}
