Linked List Cycle
​
* Use Two pointers ,say slow and fast.
* Slow will move 1 step and fast will move 2 step if next two pointers are not null.
* Once you find slow and fast are equal, then loop exist and return true.
* Else return false.