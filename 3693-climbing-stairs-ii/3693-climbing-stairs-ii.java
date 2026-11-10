class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int minPrevCost = Integer.MAX_VALUE;
            
            for (int k = 1; k <= 3; k++) {
                if (i - k >= 0) {
                    int jumpCost = k * k;
                    minPrevCost = Math.min(minPrevCost, dp[i - k] + jumpCost);
                }
            }
            
            dp[i] = minPrevCost + costs[i - 1];
        }
        
        return dp[n];
    }
}
