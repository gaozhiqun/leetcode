package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午11:22
 */
public class Leetcode_1093_sampleStats {

    public static void main(String[] args) {
        Leetcode_1093_sampleStats sampleStats = new Leetcode_1093_sampleStats();
        double[] ret = sampleStats.sampleStats(new int[]{
                0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        });
        for (double d : ret) {
            System.out.println(d);
        }
    }


    public double[] sampleStats(int[] count) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double mean = 0;
        double mode = 0;
        int modeCnt = 0;
        int total = 0;
        for (int i = 0; i < 256; ++i) {
            int cnt = count[i];
            if (cnt == 0) {
                continue;
            }
            mean = (mean * total + i * cnt) / (total + cnt);
            total += cnt;
            if (cnt > modeCnt) {
                modeCnt = cnt;
                mode = i;
            }
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        double median = getMedian(count, total);

        return new double[]{min, max, mean, median, mode};


    }
    private double getMedian(int[] count, int cnt) {
        int c = 0;
        boolean even = (cnt % 2 == 0);
        int half = cnt / 2;

        for(int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                c += count[i];
                if (c == half) {
                    if (even) {
                        for(int j = i + 1; j < 256; j++) {
                            if (count[j] > 0) {
                                return (j + i) / (double)2;
                            }
                        }

                    } else {
                        for(int j = i + 1; j < 256; j++) {
                            if (count[j] > 0) {
                                return (double) j;
                            }
                        }
                    }
                } else if (c > half) {
                    return (double) i;
                }
            }
        }
        return (double) 0;
    }



}
