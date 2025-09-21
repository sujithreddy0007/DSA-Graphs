class Solution {
    public void dfs(int[][] res, int[][] vist, int row, int col, int color, int orgCol) {
        int n = res.length;
        int m = res[0].length;
        res[row][col] = color;
        vist[row][col] = 1;
        int[] rowArr = { -1, 0, 1, 0 };
        int[] colArr = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nrow = row + rowArr[i];
            int ncol = col + colArr[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vist[nrow][ncol] == 0 && res[nrow][ncol] == orgCol) {
                dfs(res, vist, nrow, ncol, color, orgCol);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        int orgCol = image[sr][sc];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = image[i][j];
            }
        }
        res[sr][sc] = color;
        int[][] vist = new int[n][m];
        dfs(res, vist, sr, sc, color, orgCol);
        return res;
    }
}