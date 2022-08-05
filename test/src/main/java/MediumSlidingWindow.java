import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/5 8:10 下午
 */
public class MediumSlidingWindow {

    public static void main(String[] args) {
        MediumSlidingWindow mediumSlidingWindow = new MediumSlidingWindow();
        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        double[] result = mediumSlidingWindow.getMediumArray(array, 3);
        System.out.println(result);
    }

    public double[] getMediumArray(int[] array, int k) {
        int[] sortedArray = Arrays.copyOfRange(array, 0, k);
        double[] result = new double[array.length - k + 1];
        Arrays.sort(sortedArray);
        for (int i = 0; i < result.length; i++) {
            result[i] = getMedium(sortedArray, k);
            if (i < result.length - 1) {
                sortedArray = adjustArray(sortedArray, array, i, k);
            }
        }
        return result;
    }


    public int[] adjustArray(int[] sortedArray, int[] array, int l, int k) {
        int[] result = new int[sortedArray.length];
        int lv = array[l];
        int rv = array[l + k];
        int j = 0;
        boolean removed = false;
        boolean added = false;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == lv && !removed) {
                removed = true;
            } else {
                if (sortedArray[i] > rv && !added) {
                    result[j++] = rv;
                    added = true;
                }
                result[j++] = sortedArray[i];
            }
        }
        if (!added) {
            result[j++] = rv;
        }
        return result;
    }


    public double getMedium(int[] array, int k) {
        return k % 2 > 0 ? array[k / 2] : (double) (array[k / 2] + array[k / 2 - 1]) / 2;
    }
}
