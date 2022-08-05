package algorithm.huawei;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午4:46
 */
public class MakeSort {

    public static void main(String[] args) {
        MakeSort makeSort = new MakeSort();
        System.out.println(Integer.parseInt("A", 16));
//        System.out.println(makeSort.makeSort(new int[]{1, 3, 2, 4}));
//        System.out.println(makeSort.makeSort(new int[]{1, 3, 0, 4}));
//        System.out.println(makeSort.makeSort(new int[]{4, 0, 3, 1}));
        System.out.println(makeSort.makeSort(new int[]{1, 1, 2, 2, 3, 4, 4, 3, 5, 6, 7}));
    }


    public int makeSort(int[] arr) {
        //检查单调增
        int d = -1;
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                continue;
            }
            sorted = false;
            if (d >= 0) {
                d = -1;
                break;
            }
            if (arr[i + 1] < arr[i - 1]) {
                d = i - 1;
            } else {
                d = i;
            }
        }
        if (sorted) {
            return Math.min(arr[0], arr[arr.length - 1]);
        } else if (d >= 0) {
            return arr[d];
        }
        sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                continue;
            }
            sorted = false;
            if (d >= 0) {
                d = -1;
                break;
            }
            if (arr[i + 1] > arr[i - 1]) {
                d = i - 1;
            } else {
                d = i;
            }
        }
        if (sorted) {
            return Math.min(arr[0], arr[arr.length - 1]);
        } else if (d >= 0) {
            return arr[d];
        }
        return -1;
    }


}
