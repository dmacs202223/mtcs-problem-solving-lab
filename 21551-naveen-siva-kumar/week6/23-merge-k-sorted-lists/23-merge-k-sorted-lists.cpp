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
    
    struct compare {
        bool operator()(const ListNode* l, const ListNode* r) {
            return l->val > r->val;
        }
    };
    
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        std::priority_queue<ListNode*, std::vector<ListNode*>, compare > heap;
        //template,container,comparotor
        
        ListNode head(0);  //making some temporory head
        
        ListNode *curNode = &head;
        
        int i, k, n = lists.size();
        
        for (i = 0; i < n; i++)
            if (lists[i]) heap.push(lists[i]);   //push all the heads first
        
        while (!heap.empty()){
            
            curNode->next = heap.top();   //pop the min ele
            heap.pop();                
            curNode = curNode->next;
            
            if (curNode->next) heap.push(curNode->next);   //if the popped head has next ele then that will be its ew head 
        }
        
        return head.next;
    }
};