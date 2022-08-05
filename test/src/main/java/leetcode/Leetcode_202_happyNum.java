package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_202_happyNum {

    public static void main(String[] args) {
        Leetcode_202_happyNum l = new Leetcode_202_happyNum();
        System.out.println(l.isHappy(19));
        System.out.println(l.isHappy(2));
    }

    Set<Integer> visited = new HashSet<>();


    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (visited.contains(n)) {
            return false;
        }
        visited.add(n);
        int next = 0;
        while (n > 0) {
            int m = n % 10;
            n /= 10;
            next += m * m;
        }
        return isHappy(next);
    }

}