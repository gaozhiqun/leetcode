package algorithm.math;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午8:59
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int maxTries = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(maxTries));
    }
}
