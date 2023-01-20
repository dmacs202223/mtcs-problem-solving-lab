122. Best Time to Buy and Sell Stock II:

Notes: 
1. Declare day0 profit as 0.
2. Calculate profit for each day from day1.
3. Find the cumulative Profit.
4. Hint: ( dp[i] = dp[i-1] + Math.max(prices[i] - prices[i-1], 0) ).

Time Complexity : O(N)
Space Complexity : O(N)  { for constant space complexity, use variable instead dp array.}
