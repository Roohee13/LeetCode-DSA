import java.util.*;

class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);

            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int node, int start, int end, int l, int r) {

            if (r < start || end < l)
                return 0;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            return Math.max(
                query(2 * node, start, mid, l, r),
                query(2 * node + 1, mid + 1, end, l, r)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50000;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(MAX);

        SegmentTree seg = new SegmentTree(MAX + 1);

        // Initially whole range is free
        seg.update(1, 0, MAX, MAX, MAX);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                Integer right = set.ceiling(x);
                Integer left = set.floor(x);

                // Remove old segment
                seg.update(1, 0, MAX, right, right - x);

                // New segment
                seg.update(1, 0, MAX, x, x - left);

                set.add(x);

            } else {

                int x = q[1];
                int sz = q[2];

                Integer left = set.floor(x);

                int best = seg.query(1, 0, MAX, 0, left);

                best = Math.max(best, x - left);

                ans.add(best >= sz);
            }
        }

        return ans;
    }
}