package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午3:14
 */
public class QuadTree {
    public static void main(String[] args) {

    }

    public static class QuadTreeNode {
        public boolean val;
        public boolean isLeaf;
        public QuadTreeNode topLeft;
        public QuadTreeNode topRight;
        public QuadTreeNode bottomLeft;
        public QuadTreeNode bottomRight;

        public QuadTreeNode() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public QuadTreeNode(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public QuadTreeNode(boolean val, boolean isLeaf, QuadTreeNode topLeft,
                            QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        public QuadTreeNode construct(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            return buildRecursively(grid, 0, m, 0, n);
        }

        private QuadTreeNode buildRecursively(int[][] grid, int b, int t, int l, int r) {
            int val = grid[b][l];
            boolean allSame = true;
            for (int i = b; i <= t; i++) {
                for (int j = l; j <= r; j++) {
                    if (grid[i][j] != val) {
                        allSame = false;
                    }
                }
            }
            if (allSame) {
                return new QuadTreeNode(true, true);
            }
            QuadTreeNode quadTreeNode = new QuadTreeNode(false, false);
            int vMid = r - (r - l) / 2;
            int lMid = t - (t - b) / 2;
            quadTreeNode.bottomLeft = buildRecursively(grid, b, lMid, l, vMid);
            quadTreeNode.bottomRight = buildRecursively(grid, b, lMid, l, vMid);
            quadTreeNode.topLeft = buildRecursively(grid, b, lMid, l, vMid);
            quadTreeNode.topRight = buildRecursively(grid, b, lMid, l, r);
            return quadTreeNode;
        }
    }


}
