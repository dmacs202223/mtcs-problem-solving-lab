Redundant Connection:
​
This problem can be solved with Union-find Data Structure:
*  Parent array is initialized with same elements.(means Disjoint set).
*  Take each edge and find parent for both vertices using find function.
*  If both vertices have same parent, then return same.
*  Else, make second vertice's parent as first vertices.
*  If redundant connection is not found, then return -1 array.
​
*  In find function, If parent of element is same element then return element.
*  else, recusively traverse to parent of parent of element and return.
​
Time: O(MN) where M&N is row and column of the matrix.