package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_302_smallestReactangle {
    public static void main(String[] args) {
        Leetcode_302_smallestReactangle l = new Leetcode_302_smallestReactangle();
    }

    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int n = image.length;
        int m = image[0].length;
        int l = 0, r = 0;
        int left = 0, right = 0, top = 0, bottom = 0;

        // 二分最左侧黑色像素坐标
        l = 0;
        r = y;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (check_column(image, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (check_column(image, l)) {
            left = l;
        } else {
            left = r;
        }

        // 二分最右侧黑色像素坐标
        l = y;
        r = m - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (check_column(image, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (check_column(image, r)) {
            right = r;
        } else {
            right = l;
        }

        // 二分最上侧黑色素坐标
        l = 0;
        r = x;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (check_row(image, mid, left, right)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (check_row(image, l, left, right)) {
            top = l;
        } else {
            top = r;
        }

        // 二分最下侧黑色像素坐标
        l = x;
        r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (check_row(image, mid, left, right)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (check_row(image, r, left, right)) {
            bottom = r;
        } else {
            bottom = l;
        }

        return (right - left + 1) * (bottom - top + 1);
    }

    // 判断列上是否存在黑色素
    private boolean check_column(char[][] image, int col) {
        for (int i = 0; i < image.length; ++i) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }

    // 判断行上是否存在黑色素
    private boolean check_row(char[][] image, int row, int left, int right) {
        for (int j = left; j <= right; ++j) {
            if (image[row][j] == '1') {
                return true;
            }
        }
        return false;
    }


}
