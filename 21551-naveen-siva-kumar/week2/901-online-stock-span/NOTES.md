​Using a global stack,we keep track of the previous stock and their span.

For every price value check if its greater than previous stock price which is there on stack,if yes then pop it and add its span to the current span.
It may happen that we empty the stack then we need to break the loop.  
