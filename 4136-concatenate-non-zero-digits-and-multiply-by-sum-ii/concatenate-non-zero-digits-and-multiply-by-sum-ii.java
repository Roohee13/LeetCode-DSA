class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                digits.add(s.charAt(i) - '0');
                pos.add(i);
            }
        }

        int m = digits.size();

        // Powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix concatenated number
        long[] prefNum = new long[m + 1];

        // Prefix digit sum
        int[] prefSum = new int[m + 1];

        for (int i = 0; i < m; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        // leftId[i] = first non-zero digit index >= i
        int[] leftId = new int[n];
        Arrays.fill(leftId, -1);

        int p = 0;
        for (int i = 0; i < n; i++) {
            while (p < m && pos.get(p) < i)
                p++;
            if (p < m)
                leftId[i] = p;
        }

        // rightId[i] = last non-zero digit index <= i
        int[] rightId = new int[n];
        Arrays.fill(rightId, -1);

        p = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (p >= 0 && pos.get(p) > i)
                p--;
            if (p >= 0)
                rightId[i] = p;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int L = leftId[l];
            int R = rightId[r];

            if (L == -1 || R == -1 || L > R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L + 1;

            long number = (prefNum[R + 1]
                    - (prefNum[L] * pow10[len]) % MOD
                    + MOD) % MOD;

            long sum = prefSum[R + 1] - prefSum[L];

            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}