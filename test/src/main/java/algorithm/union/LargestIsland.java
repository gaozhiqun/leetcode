package algorithm.union;

import java.awt.geom.Area;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/8 下午5:41
 */
public class LargestIsland {
    public static void main(String[] args) {

    }

    public int largestIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {

            }
        }
        return -1;

    }

    public static class AreaUnion {
        int x, y, square;
        AreaUnion parent;

        public AreaUnion(int x, int y, int square) {
            this.x = x;
            this.y = y;
            this.square = square;
            this.parent = null;
        }

        public void union(AreaUnion area1, AreaUnion area2) {
            AreaUnion union1 = find(area1);
            AreaUnion union2 = find(area1);
            if (union1.square > union2.square) {
                union1.square += union2.square;
                union2.parent = union1;
            } else {
                union2.square += union1.square;
                union1.parent = union2;
            }
        }

        public AreaUnion find(AreaUnion area) {
            while (area.parent != null) {
                area = area.parent;
            }
            return area;
        }
    }
}

