class StockSpanner {
public:
    stack<pair<int,int>> stock;
    StockSpanner() {
        
        //vector<int> stock_span;
        //stock_span.push_back(null);        
    }
    
    int next(int price) {
        int span =1;
        if(this->stock.size()==0){
            this->stock.push({price,span});
            //stock_span.push_back(span);
            //cout<<"stock.top().first "<<stock.top().first<<endl;
            //cout<<"stock.top().second "<<stock.top().second<<endl;
            return span;
        }
        else{
            if(price<this->stock.top().first){
                this->stock.push({price,span});
                //cout<<"stock.top().first "<<stock.top().first<<endl;
                //cout<<"stock.top().second "<<stock.top().second<<endl;
                return span;
            }
            else {
                while(price>=this->stock.top().first){
                    
                    span+=stock.top().second;
                    this->stock.pop();
                    if(stock.empty()){
                        break;
                    }
                }
                this->stock.push({price,span});
                //cout<<"stock.top().first "<<stock.top().first<<endl;
                //cout<<"stock.top().second "<<stock.top().second<<endl;
                return span;
            }
            
        }
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */