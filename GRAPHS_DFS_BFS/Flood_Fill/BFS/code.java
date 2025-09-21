class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int orgPix = image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        int[][] vist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vist[i][j] = image[i][j];
            }
        }
        vist[sr][sc] = color;
        queue.offer(new Pair(sr, sc));
        int[] rowArr = { -1, 0, 1, 0 };
        int[] colArr = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowArr[i];
                int ncol = col + colArr[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vist[nrow][ncol] != color
                        && image[nrow][ncol] == orgPix) {
                    vist[nrow][ncol] = color;
                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }
        return vist;
    }
}