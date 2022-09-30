class Solution {
        
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) 
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int pivotPos = partition(nums, left, right);
            int count = pivotPos - left + 1;
            if(count < k){
                k = k - count;
                left = pivotPos + 1;
            }else if(count > k){
                right = pivotPos - 1;
            }else{
                return nums[pivotPos];
            }
        }
        return 0;
    }
    
    public int partition(int[] nums,int left,int right) {
        int pivot = nums[right];
        int leftBound = left;
        int rightBound = right - 1;
        
        while(leftBound <= rightBound) {
            if(nums[leftBound] >= pivot)
                leftBound++;
            else if(nums[rightBound] < pivot)
                rightBound--;
            else 
                swap(nums, leftBound++, rightBound--);
        }
        swap(nums, leftBound, right);
        return leftBound;
    }
    
    public void swap(int[] arr,int l,int p) {
        int temp = arr[l];
        arr[l] = arr[p];
        arr[p] = temp;
    }
}
