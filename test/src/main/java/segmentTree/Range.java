package segmentTree;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/26 下午5:27
 */
public class Range {


    /**
     * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
     * <p>
     * addRange(int left, int right) 添加半开区间 [left, right)，跟踪该区间中的每个实数。
     * 添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
     * queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true。
     * removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
     * 0 < left < right < 10^9
     */
    public static class RangeModule {

        TreeSet<Interval> ranges;

        public RangeModule() {
            ranges = new TreeSet<>();
        }

        public void addRange(int left, int right) {
            --right;
            Iterator<Interval> iterator = ranges.tailSet(new Interval(0, left - 1))
                    .iterator();
            while (iterator.hasNext()) {
                Interval cur = iterator.next();
                if (cur.r >= left) {
                    left = Math.min(cur.l, left);
                    right = Math.max(cur.r, right);
                    iterator.remove();
                }
            }
            ranges.add(new Interval(left, right));
        }

        public boolean queryRange(int left, int right) {
            Interval iv = ranges.higher(new Interval(0, left));
            return (iv != null && iv.l <= left && right <= iv.r);
        }

        public void removeRange(int left, int right) {
            --right;
            Iterator<Interval> iterator = ranges.tailSet(new Interval(0, left - 1))
                    .iterator();
            List<Interval> temp = new ArrayList<>();
            while (iterator.hasNext()) {
                Interval cur = iterator.next();
                if (right < cur.l) {
                    break;
                }
                if (cur.l < left) {
                    temp.add(new Interval(cur.l, left));
                }
                if (right < cur.r) {
                    temp.add(new Interval(right, cur.r));
                    iterator.remove();
                }
            }
            ranges.addAll(temp);
        }


        class Interval implements Comparable<Interval>{
            int l;
            int r;

            public Interval(int left, int right){
                this.l = left;
                this.r = right;
            }

            @Override
            public int compareTo(Interval that){
                if (this.r == that.r) {return this.l - that.r;}
                return this.r - that.r;
            }
        }
    }
}
