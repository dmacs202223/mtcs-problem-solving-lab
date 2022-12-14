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
    ListNode* deleteDuplicates(ListNode* head) {
        
        ListNode* sentinel = new ListNode(0,head);
        ListNode* first = sentinel;
        
        while(head!=nullptr){
            if(head->next!=nullptr && head->val == head->next->val){
                while(head->next!=nullptr && head->val == head->next->val){
                    head = head->next;
                }
                first->next = head->next;
            }
            else{
                first=first->next;
            }
            head= head->next;
        }
        return sentinel->next;
    }
};