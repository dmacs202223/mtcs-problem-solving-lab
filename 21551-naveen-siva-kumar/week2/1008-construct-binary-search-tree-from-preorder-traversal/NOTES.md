​BASIC IDEA:
  Doing it recursively;
    First create a node with left most element.
    This node is our current root.
    
    Find index of element whose value is less than our root's value and its next is greater than root's value. Say that index as mid
    
    So the elements from root+1 index to mid will go recursvely to root's left and remaining elements got o root's right.
    
    finally return the root.
    
  Special cases:
    Where there is only one element. then return the root.
    If we couldn't find the mid
      Then see if the remaining elements have to go to its left or right child occordingly send to it and return root.
