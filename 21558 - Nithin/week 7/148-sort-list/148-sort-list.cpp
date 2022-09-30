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
    
    ListNode* mergelists(ListNode* list1,ListNode* list2){
        if(!list1)
            return list2;
        if(!list2)
            return list1;
        
        ListNode* temp = new ListNode();
        ListNode* newNode = temp;
        if(list1->val <= list2->val){
            temp->next = list1;
            temp->next->next = mergelists(list1->next,list2);
        }
        else
        {
            temp->next = list2;
            temp->next->next = mergelists(list1,list2->next);
        }
        return newNode->next;
        
    }
    
    /*void display(ListNode* start) {
        ListNode* p = start; // current node set to head
        while(p != NULL) { //traverse until current node isn't NULL
                cout << p -> val<< " ";
                p = p -> next; // go to next node
        }
    }*/

    
    void splittinglist(ListNode* head,ListNode** list1,ListNode** list2){
        ListNode* tort = head;
        ListNode* hare = head->next;
        
        while(hare != NULL){
            hare = hare->next;
            
            if(hare != NULL){
                tort = tort->next;
                hare = hare->next;
            }
        }
        
        *list1 = head;
        *list2 = tort->next;
        
        tort->next = NULL;
        
       // display(*list1);
       // display(*list2);
    }
    
    void mergeSort(ListNode** start){
        ListNode* head = *start;
        if(head == NULL || head->next == NULL)
            return;
        
        
        ListNode* list1;
        ListNode* list2;
        
        splittinglist(head,&list1,&list2);
        mergeSort(&list1);
        mergeSort(&list2);
        
        *start = mergelists(list1,list2);
    }
    ListNode* sortList(ListNode* head) {
        mergeSort(&head);
        
        return head;
    }
};