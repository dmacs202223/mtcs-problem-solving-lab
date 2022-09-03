class StockSpanner:
    def __init__(self):
        self.stocks = []
        self.spans = []
        
    def next(self, price: int) -> int:                
        span = 1
        i = len(self.stocks) - 1
        while i >= 0 and self.stocks[i] <= price:            
            span += self.spans[i]
            i = i - self.spans[i]
        self.stocks.append(price)
        self.spans.append(span)
        return span


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
