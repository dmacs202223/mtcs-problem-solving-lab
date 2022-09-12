
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        int ans[] = new int[nums.length-k+1];
        
        int iter = 0;
        
        
        for(int i=0;i<nums.length;i++){
            
            if(i>=k){
                if(!q.isEmpty() && q.getFirst() == nums[i-k])
                    q.removeFirst();
            } //This is to remove the max after we slid past that element
            
            while(!q.isEmpty() && ( q.peekLast()!=null && q.peekLast()<nums[i])){
                q.pollLast();
            }    //removing all the non potential max elements from queue to make it monotonic
                
            q.offerLast(nums[i]);
            //pushing the element into queue

            if(i>=k-1){
                ans[iter]=q.peekFirst();
                iter++;
            } //adding the max to the returning integer array
            
            
        }
        return ans;
    }
}