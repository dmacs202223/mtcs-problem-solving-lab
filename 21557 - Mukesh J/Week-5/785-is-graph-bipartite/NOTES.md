Is Graph Bipartite?
​
I am solving problem using BFS method.
​
Idea:
1. Basic understanding (Edges connecting two vertices should be in different set).
2. Let one set is red and other is blue.
3. If current node is Red color, then it's adjacent nodes should be different color (blue).
4. Continue to divide nodes into two different sets.
5.  If we are able to divide nodes into two sets, then return true (means it is bipartite).
6.  Else return false.
​
Time Complexity : O(N) because all nodes are traversed once.