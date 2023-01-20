class Solution {
    public int maxProduct(int[] nums) {

        // // This is the brute force method of solving the given problem
        // int n = nums.length;
        // int max = nums[0];

        // for(int i=0; i<n; i++) {
        //   int temp = 1;
        //   for(int j=i; j<n; j++) {
        //     temp *= nums[j];
        //     max = Math.max(max, temp);
        //   }
        // }

        // return max;

        // Using Dynamic Programming

        int n = nums.length;
        int local_max = nums[0];
        int local_min = nums[0];
        int global_max = nums[0];

        for(int i=1; i<n; i++) {
          int temp = local_max;
          local_max = Math.max(temp * nums[i], Math.max(local_min * nums[i], nums[i]));
          local_min = Math.min(temp * nums[i], Math.min(local_min * nums[i], nums[i]));

          global_max = Math.max(local_max, global_max);
        }
        return global_max;
    }
}
