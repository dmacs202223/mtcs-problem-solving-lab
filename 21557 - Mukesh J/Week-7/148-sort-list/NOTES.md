Sort List (Hint: Used Merge Sort)
​
* Having two pointers, say slow and fast, will help us to find mid element. So that you can split list into two halves.
* Keep track of prev node of slow because you need put prev next as null (First half ends).
* Then recursively pass left half and right half into sortlist function.
* After both left and right are sorted, then merge both list.
​
Merge Function:
* First create a dummy node and compare first node of both left and right node, then whichever is left, just add it to dummy node  util anyone  of the list is empty.
* if left list is not empty, then add remaining left list to dummy list.
* if right list is not empty, then add remaining right list to dummy list.
* finally, return dummynode.