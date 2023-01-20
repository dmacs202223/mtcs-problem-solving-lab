class Solution {
    public int maxProfit(int[] prices) {
        // Simple O(n) solution, Greedy Approach!

        // int sum = 0;
        // for(int i=0;i<prices.length-1;i++)
        // {
        //     if(prices[i+1]>prices[i])
        //         sum = sum + prices[i+1]-prices[i];
        // }
        // return sum;

        int n = prices.length;
        int[] dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1] + Math.max(0,prices[i]-prices[i-1]);
        }
        return dp[n-1];
    }
}
