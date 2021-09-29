/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int cnt = 0;
        while (curr != null) {
            ++cnt;
            curr = curr.next;
        }
        
        ListNode[] res = new ListNode[k];
        int each = cnt / k, rem = cnt % k;
        for (int i = 0; i < k; ++i) {
            res[i] = head;
            
            if (head == null) {
                continue;
            }
            
            for (int j = 0; j < each + (rem > 0 ? 1 : 0) - 1; ++j) {
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
            --rem;
        }
        return res;
    }
}
