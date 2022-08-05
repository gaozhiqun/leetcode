package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/28 4:43 下午
 */
public class AddCaculateNum {
    public static void main(String[] args) {

    }

    public List<String> calculate(int[] array, int target) {
        List<String> result = new ArrayList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(array[0]);
        tempList.add(array[0]);
        helper(stringBuilder, array, 1, target, tempList, "+", result);
        helper(stringBuilder, array, 1, target, tempList, "-", result);
        helper(stringBuilder, array, 1, target, tempList, "*", result);
        return result;
    }

    private void helper(StringBuilder cur, int[] array, int i, int target,
                        LinkedList<Integer> nums, String op, List<String> resultList) {
        int curL = cur.length();
        cur.append(op);
        cur.append(array[i]);
        switch (op) {
            case "+":
                nums.add(array[i]);
                break;
            case "-":
                nums.add(-array[i]);
                break;
            case "*":
                int lastNum = nums.getLast();
                lastNum *= array[i];
                nums.set(nums.size() - 1, lastNum);
                break;
            default:
        }
        if (i == array.length - 1) {
            int result = 0;
            for (int num : nums) {
                result += num;
                if (result == target) {
                    resultList.add(cur.toString());
                }
            }
        } else {
            helper(cur, array, 1, target, nums, "+", resultList);
            helper(cur, array, 1, target, nums, "-", resultList);
            helper(cur, array, 1, target, nums, "*", resultList);
        }


    }

}
