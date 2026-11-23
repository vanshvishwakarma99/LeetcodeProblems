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
    ListNode* insertGreatestCommonDivisors(ListNode* head) {

        if(head == NULL && head->next == NULL){
            return head;
        }

        ListNode* curr = head;

        while (curr != nullptr && curr->next != nullptr) {
            int g = gcd(curr->val, curr->next->val);
            ListNode* nextNode = curr->next;

            curr->next = new ListNode(g, nextNode);
            curr = nextNode;
        }

        return head;
    }

private:
    int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
};