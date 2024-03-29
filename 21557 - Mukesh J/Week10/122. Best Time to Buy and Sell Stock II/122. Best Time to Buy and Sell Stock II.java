class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] dp= new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            dp[i]= dp[i-1] + Math.max(prices[i]-prices[i-1],0);
        }
        return dp[n-1];
    }
}
