package leetcode;


public class Leetcode_991_brokenCalc {
    public static void main(String[] args) {
        Leetcode_991_brokenCalc l = new Leetcode_991_brokenCalc();
    }


    public int brokenCalc(int startValue, int target) {
        int ret = 0;
        while (target > startValue) {
            ++ret;
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
        }
        return ret + startValue - target;
    }
}
