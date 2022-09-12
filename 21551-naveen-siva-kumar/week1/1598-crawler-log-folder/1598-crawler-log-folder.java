class Solution {
    public int minOperations(String[] logs) {
        
        int ans =0;
        
        for(String s : logs){
            
            if(!(s.equals("../")||s.equals("./"))) {
                
                ans++;
                
            }
            else if(s.equals("../")){
                
                
                 if(ans!=0) ans--;
            }
            else{
               continue;
            }
        }
        
        return ans;
        
    }
}