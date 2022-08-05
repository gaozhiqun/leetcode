/**
 * @author zhiqungao@tencent.com
 * @date 2021/1/29 8:34 下午
 */
public class JumpGame {

    public static void main(String[] args) {

    }

    public int minJump1(int[] array) {
        int[] steps = new int[array.length];
        steps[array.length - 1] = 0;
        for (int i = array.length - 2; i > -1; i--) {
            int minNextStep = Integer.MAX_VALUE;
            for (int j = 1; j < array[j] && (i + j) < array.length; j++) {
                Math.min(minNextStep, steps[j]);
                steps[i] = ++minNextStep;
            }
        }
        return steps[0];
    }

    public int minJump2(int[] array) {
        int step = 0;
        int cur = 0;
        while (cur < array.length) {
            int next = Integer.MIN_VALUE;
            for (int i = 1; i < array[cur] && i + cur < array.length; i++) {
                next = Math.max(next, cur + array[cur + i]);
            }
            cur = next;
            step++;
        }
        return step;
    }
}
