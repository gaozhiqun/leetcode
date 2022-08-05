package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_274_hIndex {
    public static void main(String[] args) {
        Leetcode_274_hIndex l = new Leetcode_274_hIndex();
        System.out.println(l.hIndex(new int[]{
                3, 0, 6, 1, 5
        }));
        System.out.println(l.hIndex(new int[]{
                1, 3, 1
        }));
        System.out.println(l.hIndex(new int[]{
                100
        }));
    }

    /**
     * 总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


    public int hIndex2(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

}
