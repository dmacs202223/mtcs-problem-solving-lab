/**

Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price. 


  Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6.
 

 Constraints:

1 <= price <= 105
At most 104 calls will be made to next.

  
  Data Structure: 

Stack, Monotonic Stack.
  

  Idea:
  1. Create a class node and declare the node constructor with count and value.
  2. Declare the global stack variable with Node.
  3. In Next function, Initialize count with 1.
  4. While its value is greater than the stock price at the top of the stack, add the span of that stock to the currently computed span and pop the stack.
  5. Push the current price with its span onto the stack.
  6. Finally, return count from next function.
  7. Time: O(N) where N is the length of the given array.

**/

  Solution:

class StockSpanner {
    class Node
    {
        int val;
        int count;
        Node (int val, int count)
        {
            this.val = val;
            this.count = count;
        }
    }
    
    Stack<Node> span;
    public StockSpanner() {
        span = new Stack<Node>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!span.isEmpty() && span.peek().val<=price)
        {
            count+=span.pop().count;
        }
        Node node = new Node(price,count);
        span.push(node);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
