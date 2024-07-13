class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[cols - 1] = obstacleGrid[rows - 1][cols - 1] == 0 ? 1 : 0;
        for (int i = cols - 2; i >= 0; i--)
            dp[i] = obstacleGrid[rows - 1][i] == 1 ? 0 : dp[i + 1];
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                int right = j + 1 < cols ? dp[j + 1] : 0;
                int down = dp[j];
                dp[j] = right + down;
            }
        }
        return dp[0];
    }
}