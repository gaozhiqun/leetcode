package leetcode;

import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_478_randPoint {

    public static void main(String[] args) {

//        System.out.println(l.makesquare(new int[]{1, 1, 2, 2, 2}));
//        System.out.println(l.makesquare(new int[]{3, 3, 3, 3, 4}));
//        System.out.println(l.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(l.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));

    }

    double radius, x_center, y_center;

    Leetcode_478_randPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x_center, d * Math.sin(theta) + y_center};
    }


}
