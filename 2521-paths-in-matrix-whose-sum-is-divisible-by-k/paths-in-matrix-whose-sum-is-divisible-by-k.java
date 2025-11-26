class Solution {
    static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                for (int r = 0; r < k; r++) {
                    int prev = dp[i][j][r]; 
                    if (prev == 0) continue;

                    // Move Down
                    if (i + 1 < m) {
                        int newRem = (r + grid[i+1][j]) % k;
                        dp[i+1][j][newRem] = (dp[i+1][j][newRem] + prev) % MOD;
                    }

                    // Move Right
                    if (j + 1 < n) {
                        int newRem = (r + grid[i][j+1]) % k;
                        dp[i][j+1][newRem] = (dp[i][j+1][newRem] + prev) % MOD;
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
