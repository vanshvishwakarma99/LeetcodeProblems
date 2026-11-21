class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        const int MOD = 1e9 + 7;
        sort(arr.begin(), arr.end());
        unordered_map<int, long long> dp;
        long long ans = 0;

        for (int x : arr) {
            dp[x] = 1;
            for (int a : arr) {
                if (a >= x) break;
                if (x % a == 0 && dp.count(x / a)) {
                    dp[x] = (dp[x] + dp[a] * dp[x / a]) % MOD;
                }
            }
            ans = (ans + dp[x]) % MOD;
        }
        return ans;
    }
};