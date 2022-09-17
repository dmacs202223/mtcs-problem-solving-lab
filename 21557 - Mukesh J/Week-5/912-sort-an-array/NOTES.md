Sort an Array:
​
I am solving using Heap Sort with Heapify as Bottom- up approach because heapsort with bottom-up heapify approach is O(NlogN).
​
Idea:
In Heapify function:
1. We are trying to find max of current node, left of the node and right of the node.
2. Using recursive method, we heapify the whole tree.
3. At every node, root node value is greater than the left child and right child node.
​
In Heap-Sort:
1. Firstly, find the size of the given array.
2. (We can't do heapify for leaf node). The formula for finding the starting of the root node in botom-up approach is (size/2)-1.
3. Secondly, we build a max-heap using heapify function.
4. Once Max-heapify is done, then swap first element with last element. so that largest element goes back.
5. And continue heapify for n-1, n-2,...
6. once the whole tree is heapify, then the given array is sorted.(Ascending).
​
Time Complexity: O(NlogN).
​