class Solution {
public:
    int mod = 1e9 + 7;
    long long dpp(int i, int n, vector<long long>& dp, vector<long long>& prefix, const vector<int>& rangeEnd) {
        if (i >= n) return 1;
        if (dp[i] != -1) return dp[i];
        int j = rangeEnd[i];
        dp[i] = (prefix[i+1] - prefix[j + 2] + mod) % mod;
        return dp[i];
    }
    int countPartitions(vector<int>& nums, int k) {
        int n = nums.size();
        vector<long long> dp(n + 2, -1);
        vector<long long> prefix(n + 3, 0);
        vector<int> rangeEnd(n);
        multiset<int> s;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n) {
                s.insert(nums[j]);
                int mx = *s.rbegin();
                int mn = *s.begin();
                if (mx - mn > k) {
                    s.erase(s.find(nums[j]));
                    break;
                }
                ++j;
            }
            rangeEnd[i] = j - 1;
            s.erase(s.find(nums[i]));
        }
        // for(int i:rangeEnd) cout<<i<<" ";
        cout<<"\n";
        dp[n] = 1;
        dp[n+1]=0;
        prefix[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = dpp(i, n, dp, prefix, rangeEnd);
            prefix[i] = (dp[i] + prefix[i + 1]) % mod;
        }
        // for(int i:dp) cout<<i<<" ";
        // for(int i:prefix) cout<<i<<" ";
        return dp[0];
    }
};