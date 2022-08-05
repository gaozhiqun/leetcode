package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_228_summaryRanges {

    public static void main(String[] args) {
        Leetcode_228_summaryRanges l = new Leetcode_228_summaryRanges();
        System.out.println(l.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(l.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(l.summaryRanges(new int[]{-1}));
        System.out.println(l.summaryRanges(new int[]{0}));
    }


    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }


    private String buildInterval(int i, int j) {
        if (i == j) {
            return "" + i;
        }
        return String.format("%d->%d", i, j);
    }
}