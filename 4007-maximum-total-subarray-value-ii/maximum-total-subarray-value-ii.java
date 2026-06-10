import java.util.*;

class Solution {

    private int[][] stMax, stMin;
    private int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));

        for (int l = 0; l < n; l++) {
            long val = getValue(l, n - 1);
            pq.offer(new Node(l, n - 1, val));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.value;

            if (cur.r > cur.l) {
                int newR = cur.r - 1;
                pq.offer(new Node(
                        cur.l,
                        newR,
                        getValue(cur.l, newR)
                ));
            }
        }

        return ans;
    }

    private long getValue(int l, int r) {
        return (long) queryMax(l, r) - queryMin(l, r);
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(
                        stMax[j - 1][i],
                        stMax[j - 1][i + (1 << (j - 1))]
                );

                stMin[j][i] = Math.min(
                        stMin[j - 1][i],
                        stMin[j - 1][i + (1 << (j - 1))]
                );
            }
        }
    }

    private int queryMax(int l, int r) {
        int j = log[r - l + 1];
        return Math.max(
                stMax[j][l],
                stMax[j][r - (1 << j) + 1]
        );
    }

    private int queryMin(int l, int r) {
        int j = log[r - l + 1];
        return Math.min(
                stMin[j][l],
                stMin[j][r - (1 << j) + 1]
        );
    }

    static class Node {
        int l, r;
        long value;

        Node(int l, int r, long value) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
    }
}