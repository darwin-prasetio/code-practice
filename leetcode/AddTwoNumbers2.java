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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = convertListNodeToStack(l1), s2 = convertListNodeToStack(l2);
        ListNode head = null, next = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum %= 10;
            head = new ListNode(sum);
            head.next = next;
            next = head;
        }
        return head;
    }
    
    private Stack<Integer> convertListNodeToStack(ListNode l) {
        Stack<Integer> s = new Stack<>();
        while (l != null) {
            s.add(l.val);
            l = l.next;
        }
        return s;
    }
}
