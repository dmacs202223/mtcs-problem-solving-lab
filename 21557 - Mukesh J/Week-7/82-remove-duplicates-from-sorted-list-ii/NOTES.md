Remove Duplicates from sorted List II
​
* Use Two Pointers to keep track of previous node(Slow ) and current node(fast).
* If any value is repeating, then only fast pointer will move forward.
* Otherwise, both slow and fast pointer will move equally.
* if repeating elements are found, then only fast pointer will move till last repeating element and swap slow pointer's next with fast pointer's next.
* finally return the head node.