class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int opt1 = (i - 1 >= 0) ? dp[i - 1] + 1 : Integer.MAX_VALUE;
            int opt2 = (i - 2 >= 0) ? dp[i - 2] + 4 : Integer.MAX_VALUE;
            int opt3 = (i - 3 >= 0) ? dp[i - 3] + 9 : Integer.MAX_VALUE;
            
            int minPrev = Math.min(opt1, Math.min(opt2, opt3));
            
            dp[i] = minPrev + costs[i - 1];
        }
        
        return dp[n];
    }
}



/*
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
*/