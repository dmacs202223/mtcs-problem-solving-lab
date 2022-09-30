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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        
        ListNode* fast = list1;
        ListNode* slow = list1;
        ListNode* temp = list2;
        
        int count=0;
        while(temp->next!=NULL){
            temp=temp->next;
        }
        
        ListNode* sentinal = new ListNode(0,list1);
        
        while(count!=a-1){
            count++;
            fast=fast->next;
        }
        
        slow = fast;
        fast=fast->next;count++;
        slow->next=list2;
        while(count!=b){ fast=fast->next;count++;}
        temp->next=fast->next;
        
        return sentinal->next;
    }
};