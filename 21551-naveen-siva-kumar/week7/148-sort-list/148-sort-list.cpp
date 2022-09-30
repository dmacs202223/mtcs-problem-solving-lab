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
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head ->next == NULL)
            return head;
        
        ListNode* sentinal = new ListNode(0,head);
        ListNode* fast = head;
        ListNode* slow = head;
        ListNode* temp;
        
        while(fast != NULL && fast->next!=NULL){
            
            temp=slow;
            slow = slow->next;
            fast=fast->next->next;
            
        }
        temp->next = NULL;
        
        ListNode* left = sortList(head);
        ListNode* right = sortList(slow);
        
        return merge(left,right);
        
    }
    ListNode* merge(ListNode* l,ListNode* r){
    
        ListNode *sentinal = new ListNode(0);
        ListNode *curr = sentinal;
        
        while(l != NULL && r != NULL){
            
            if(l->val <= r->val){
                curr -> next = l;
                l = l -> next;
            }
            
            else{
                curr -> next = r;
                r = r -> next;
            }
        
            curr = curr->next;
        
        }
        
        if(l != NULL){
            curr -> next = l;
            l = l->next;
        }
        
        if(r != NULL){
            curr -> next = r;
            r = r ->next;
        }
        
        return sentinal->next;

    
    }
};