class StockSpanner {
    Stack<int []> tupleStack;
   
    public StockSpanner() {
        tupleStack = new Stack<>();
    }
    
    public int next(int price) {
        int result = 1;
        int arr [] = new int[2];
        
        while(!tupleStack.empty() && tupleStack.peek()[0]<=price){
            result += tupleStack.pop()[1];
        }
        
        arr[0]=price;
        arr[1]=result;
        tupleStack.push(arr);
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
