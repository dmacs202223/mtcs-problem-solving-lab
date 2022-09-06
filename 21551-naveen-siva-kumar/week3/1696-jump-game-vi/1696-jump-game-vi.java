class Solution {
    public int maxResult(int[] nums, int k) {
        /*using dynamic programming relation and sliding window */
        
        /*If we are taking a step to an index then its from the max of past k steps(finding max of k steps is done by sliding window) and the dp relation (adding part) takes care of max value till current step*/
        
        Deque<Integer> dq=new ArrayDeque<>();
        
        dq.addFirst(0);
        
        for(int i=1;i<nums.length;i++){
            
            nums[i]=nums[i]+nums[dq.peekFirst()];
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.removeLast();
            }
            
            dq.addLast(i);
            
            if(i-k>=dq.peekFirst()){
                dq.removeFirst();
            }
        }
        return nums[nums.length-1];
    }
}