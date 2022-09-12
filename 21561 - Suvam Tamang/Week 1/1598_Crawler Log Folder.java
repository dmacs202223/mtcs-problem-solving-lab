class Solution {
   
    public int minOperations(String[] logs) {
        
        
    //     This is one of the solution without using stack
    //     int step = 0;
    //     for(String str : logs) {
    //         if(Character.isAlphabetic(str.charAt(0)) || Character.isDigit(str.charAt(0))) {
    //             step++;
    //         }
    //         else if(str.charAt(1) == '.' && step > 0) {
    //             step--;
    //         }
    //     }
    //     return step;
    // }
    
        // Now let's try using stack for this problem
        Stack <String> stack = new Stack <> ();
        for(String log : logs){
            if(log.equals("./")){
                continue;
            }
            else if(log.equals("../")){
                if(!stack.empty())
                    stack.pop();
            }
            else{
                stack.push(log);
            }
        }
        return stack.size();    
    }
}
