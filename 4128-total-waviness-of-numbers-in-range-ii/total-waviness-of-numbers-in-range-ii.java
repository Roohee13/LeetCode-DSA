import java.util.*;

class Solution {

    private String num;
    private long[][][][][] countDp;
    private long[][][][][] sumDp;
    private boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        num = String.valueOf(x);
        int n = num.length();

        countDp = new long[n + 1][2][2][11][11];
        sumDp = new long[n + 1][2][2][11][11];
        vis = new boolean[n + 1][2][2][11][11];

        return dfs(0, 1, 0, 10, 10)[1];
    }

    private long[] dfs(int pos, int tight, int started, int prev2, int prev1) {
        if (pos == num.length()) {
            return new long[]{1L, 0L}; // {count, wavinessSum}
        }

        if (vis[pos][tight][started][prev2][prev1]) {
            return new long[]{
                    countDp[pos][tight][started][prev2][prev1],
                    sumDp[pos][tight][started][prev2][prev1]
            };
        }

        vis[pos][tight][started][prev2][prev1] = true;

        long totalCount = 0;
        long totalSum = 0;

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] res = dfs(pos + 1, newTight, 0, 10, 10);
                totalCount += res[0];
                totalSum += res[1];
            } else if (started == 0) {
                long[] res = dfs(pos + 1, newTight, 1, 10, d);
                totalCount += res[0];
                totalSum += res[1];
            } else if (prev2 == 10) {
                long[] res = dfs(pos + 1, newTight, 1, prev1, d);
                totalCount += res[0];
                totalSum += res[1];
            } else {
                int add = ((prev1 > prev2 && prev1 > d) ||
                           (prev1 < prev2 && prev1 < d)) ? 1 : 0;

                long[] res = dfs(pos + 1, newTight, 1, prev1, d);

                totalCount += res[0];
                totalSum += res[1] + add * res[0];
            }
        }

        countDp[pos][tight][started][prev2][prev1] = totalCount;
        sumDp[pos][tight][started][prev2][prev1] = totalSum;

        return new long[]{totalCount, totalSum};
    }
}