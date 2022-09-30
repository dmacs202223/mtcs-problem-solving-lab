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
        if(head == nullptr || head->next == nullptr)
            return head;
        unordered_map<int, int> map; 
        ListNode* temp = head;
        
        while(temp != NULL){
            map[temp->val]++;
            temp = temp->next;
        }
        
        ListNode* temp2 = head;
        ListNode* temp3 = head;
        while(temp2 != NULL){
            if(map[temp2->val] > 1){
                for(int i = 0;i < map[temp2->val] -1;i++){
                    temp2->next = temp2->next->next;
                }
                if(temp2 == temp3){
                    head = temp2->next;
                    temp3 = head;
                }
    
                else
                {
                    while(temp3->next != temp2)
                       temp3 = temp3->next;
                    temp3->next = temp2->next;
                }
            }
            temp2 = temp2->next;
        }
        return head;
    }
};