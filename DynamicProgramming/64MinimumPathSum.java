class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int[][] dp = new int[rows + 1][cols + 1];
        dp[rows][cols] = grid[rows][cols];
        while (rows >= 0 && cols >= 0) {
            for (int i = rows; i >= 0; i--) {
                if (i == grid.length - 1 && cols == grid[0].length - 1)
                    continue;
                int down = i + 1 < grid.length ? dp[i + 1][cols] : Integer.MAX_VALUE;
                int right = cols + 1 < grid[0].length ? dp[i][cols + 1] : Integer.MAX_VALUE;
                dp[i][cols] = grid[i][cols] + Math.min(down, right);
            }
            for (int i = cols; i >= 0; i--) {
                if (i == grid[0].length - 1 && rows == grid.length - 1)
                    continue;
                int down = rows + 1 < grid.length ? dp[rows + 1][i] : Integer.MAX_VALUE;
                int right = i + 1 < grid[0].length ? dp[rows][i + 1] : Integer.MAX_VALUE;
                dp[rows][i] = grid[rows][i] + Math.min(down, right);
            }
            cols--;
            rows--;
        }
        return dp[0][0];
    }
}