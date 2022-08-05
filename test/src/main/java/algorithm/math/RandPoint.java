package algorithm.math;


import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/20 上午11:26
 */
public class RandPoint {
    private double radius;
    private double xCenter;
    private double yCenter;

    public RandPoint(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * 极坐标
     *
     * @return
     */
    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta), d * Math.sin(theta)};
    }

}
