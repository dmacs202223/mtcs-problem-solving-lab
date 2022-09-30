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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> sol;
        int size =1;
        
        ListNode* fast = head;
        ListNode* slow = head;
        ListNode* temp;
        
        if(head==nullptr){
            for(int i=0;i<k;i++){
                sol.push_back(nullptr);
            }
            return sol;
        }
        
        while(fast->next!=nullptr) { fast = fast->next; size++; }
        //cout<<size;
        int reminder=size%k;
        int count =0;
        
        
        for(int i=0;i<reminder;i++){
            count=1;
            sol.push_back(head);
            if(head!=NULL){
                while(count!=ceil(size/float(k)) && head->next!=NULL){
                    head = head->next;
                    count++;
                }
                temp = head->next;
                head->next=NULL;
                head = temp;
            }
        }
        //cout<<reminder;
        //cout<<k-reminder<<endl;
        cout<<"    "<<ceil(size/float(k))<<"    "<<floor(size/float(k))<<endl;
        for(int i=0;i<k-reminder;i++){
            count=1;
            sol.push_back(head);
            if(head!=NULL){
                while(count!=floor(size/float(k)) && head->next!=NULL){
                    head = head->next;
                    count++;
                }
                temp = head->next;
                head->next=NULL;
                head = temp;
            }
        }
        
        
        return sol;
    }
};