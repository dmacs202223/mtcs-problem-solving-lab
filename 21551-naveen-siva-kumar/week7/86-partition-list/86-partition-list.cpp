/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        
        ListNode* sentinel = new ListNode(0,head);
        ListNode* fast = sentinel;
        ListNode* slow = sentinel;
        ListNode* temp;
        
        bool reachedX = false;
        while(fast->next!=NULL){// && fast->next-> < x){
            
            if(fast->next->val >= x){
                reachedX=true;
                fast = fast->next;
            }
            else if(fast->next->val < x && !reachedX){
                fast = fast->next;
                slow = fast;
            }
            else{
                temp = fast->next;
                fast->next = temp->next;
                temp->next = slow->next;
                slow->next = temp;
                slow = slow->next;
            }
        }
        return sentinel->next;
    }
};