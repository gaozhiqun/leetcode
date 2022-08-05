package algorithm.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/22 6:34 下午
 */
public class TwoPointer {

    int maxiumVolume(int[] height) {
        int i = 0;
        int j = height.length;
        int mm = 0;
        while (true) {
            int m = (j-i)*(height[i] <= height[j]?height[i++]:height[j--]);
            if(m > mm) mm = m;
            if(i == j) break;
        }
        return mm;
    }


}
