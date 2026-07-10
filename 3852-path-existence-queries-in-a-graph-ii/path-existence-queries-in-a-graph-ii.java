import java.util.*;

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] ans = new int[queries.length];

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] sortedNums = new int[n];
        int[] indexMap = new int[n];

        for (int i = 0; i < n; i++) {
            sortedNums[i] = arr[i][0];
            indexMap[arr[i][1]] = i;
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        LOG++;

        int[][] jump = new int[n][LOG];

        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && sortedNums[r + 1] - sortedNums[i] <= maxDiff) {
                r++;
            }
            jump[i][0] = r;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[i][k] = jump[jump[i][k - 1]][k - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int u = indexMap[queries[i][0]];
            int v = indexMap[queries[i][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            if (jump[u][LOG - 1] < v) {
                ans[i] = -1;
                continue;
            }

            int cur = u;
            int dist = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[cur][k] < v) {
                    dist += 1 << k;
                    cur = jump[cur][k];
                }
            }

            ans[i] = dist + 1;
        }

        return ans;
    }
}