class Solution {

    class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 2];
        }

        void update(int index, int val) {
            while (index < bit.length) {
                bit[index] += val;
                index += index & (-index);
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        FenwickTree tree = new FenwickTree(2 * n + 5);

        int prefix = n + 1;

        tree.update(prefix, 1);

        long ans = 0;

        for (int num : nums) {

            if (num == target)
                prefix++;
            else
                prefix--;

            ans += tree.query(prefix - 1);

            tree.update(prefix, 1);
        }

        return ans;
    }
}