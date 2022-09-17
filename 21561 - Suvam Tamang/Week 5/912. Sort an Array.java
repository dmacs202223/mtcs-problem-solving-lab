class Solution {
    public int[] sortArray(int[] nums) {
        int N = nums.length;
        
        for(int i=(N/2)-1; i>=0; i--)
            heapify(nums, nums.length, i);
        
        for(int i = N-1; i>=1; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            
            heapify(nums, i, 0);
        }
        return nums;
    }
    
    public void heapify(int[] nums, int N, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if(left < N && nums[left] > nums[largest])
            largest = left;
        
        if(right < N && nums[right] > nums[largest])
            largest = right;
        
        if(largest != i) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            
            heapify(nums, N, largest);
        }
    }
}
