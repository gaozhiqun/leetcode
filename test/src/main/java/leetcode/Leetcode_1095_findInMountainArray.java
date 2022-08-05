package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 上午12:19
 */
public class Leetcode_1095_findInMountainArray {
    public static void main(String[] args) {
        Leetcode_1095_findInMountainArray l = new Leetcode_1095_findInMountainArray();
        MountainArrayImple mountainArrayImple = new MountainArrayImple();
        System.out.println(l.findInMountainArray(3, mountainArrayImple));
    }


    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public static class MountainArrayImple implements MountainArray {

        int[] arr = new int[]{1, 2, 3, 4, 5, 3, 1};

        public MountainArrayImple() {

        }

        @Override
        public int get(int index) {
            return arr[index];
        }

        @Override
        public int length() {
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int peak = l;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    public int binarySearch(MountainArray mountainArr, int target, int l, int r, boolean flag) {
        if (!flag) {
            target *= -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountainArr.get(mid) * (flag ? 1 : -1);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
