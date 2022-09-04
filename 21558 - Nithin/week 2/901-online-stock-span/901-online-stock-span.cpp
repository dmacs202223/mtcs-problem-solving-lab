class StockSpanner {
public:
    stack<pair<int, int>> stck;
    StockSpanner() {
        
    }
    
    int next(int price) {
        int stprice_span = 1;
        while(stck.empty() == false && price>=stck.top().first){
            stprice_span += stck.top().second;
            stck.pop();
        }
        stck.push({price, stprice_span});
        return stprice_span;
        
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */