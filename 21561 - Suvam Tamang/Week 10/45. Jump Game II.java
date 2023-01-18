class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int [] min_dist = new int[n];
        for(int i=1; i<n; i++) {
            min_dist[i] = Integer.MAX_VALUE;
        }
        min_dist[0] = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<=i+nums[i] && j<n; j++) {
                min_dist[j] = Math.min(min_dist[j], min_dist[i]+1);
            }
        }
        return min_dist[n-1];
    }
}
