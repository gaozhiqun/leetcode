package leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_223_computeArea {

    public static void main(String[] args) {
        Leetcode_223_computeArea l = new Leetcode_223_computeArea();
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1), overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return area1 + area2 - overlapArea;
    }
}