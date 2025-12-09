class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        final int MOD = 1_000_000_007;

        int maxVal = 200000; 
        long[] right = new long[maxVal + 1];

        // Fill frequency for right side
        for (int x : nums) {
            right[x]++;
        }

        long[] left = new long[maxVal + 1];
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            right[val]--;  // remove current from right side

            int doubled = val * 2;
            if (doubled <= maxVal) {
                ans = (ans + left[doubled] * right[doubled]) % MOD;
            }

            left[val]++; // add current to left side
        }

        return (int) ans;
    }
}
