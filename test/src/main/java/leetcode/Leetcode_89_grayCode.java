package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_89_grayCode {

    /**
     * 输入：s1 = "great", s2 = "rgeat""abcdefghijklmnopq"
     * "efghijklmnopqcadb"
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_89_grayCode l = new Leetcode_89_grayCode();
        System.out.println(l.grayCode(0));
        System.out.println(l.grayCode(1));
        System.out.println(l.grayCode(2));
        System.out.println(l.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        if (n == 0) {
            return ans;
        }
        while (k < n) {
            List<Integer> temp = new ArrayList<>();
            for (int i = ans.size() - 1; i >= 0; --i) {
                temp.add((ans.get(i) | (1 << k)));
            }
            ++k;
            ans.addAll(temp);
        }
        return ans;
    }


}
