/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* fastPointer = head;
        ListNode* slowPointer = head;
        
        if(head==NULL || head->next == NULL){ return false;}
        if(head->next->next == NULL){return false;}
        
        while(fastPointer!=NULL || fastPointer->next!=NULL ){
            
            fastPointer =  fastPointer->next->next;
            slowPointer = slowPointer->next; 
            
            if(fastPointer==NULL || fastPointer->next==NULL ||  fastPointer->next->next == NULL){
                return false;
            }
            if(fastPointer == slowPointer) { 
                cout<<fastPointer;cout<<slowPointer;
                return true;}
            
                
        }
        return false;
    }
};