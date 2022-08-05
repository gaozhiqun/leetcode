package algorithm.array;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/15 下午9:02
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {

    }

    public int maxChunksToSorted(int[] arr) {
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        Arrays.sort(arrCopy);
        int result = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arrCopy[i] - arr[i];
            if (temp == 0) {
                result++;
            }
        }
        return result;
    }
}
