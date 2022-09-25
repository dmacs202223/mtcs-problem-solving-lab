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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k = lists.size();
        if(k == 0)
            return NULL;
        priority_queue<int, vector<int>, greater<int>> pq_merged;
        for(int i = 0;i < k;i++){
            ListNode* node = lists[i];
            while(node){
                pq_merged.push(node->val);
                node = node->next;
            }
        }
        if(pq_merged.size() == 0)
            return NULL;
        
        ListNode* merged1 = new ListNode();
        ListNode* merged = merged1;
        while(pq_merged.size()){
            merged->next = new ListNode(pq_merged.top());
            pq_merged.pop();
            merged = merged->next;
        }
        merged->next = NULL;
        merged1 = merged1->next;
        return merged1;
        
    }
};