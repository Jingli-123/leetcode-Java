/**24. Swap Nodes in Pairs (Medium)
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the 
 * problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
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
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        if(head.next != null){
            head = dummy.next.next;
        }
        
        while(dummy.next != null && dummy.next.next != null){
            ListNode curr = dummy;
            ListNode temp1 = dummy.next;
            curr.next = curr.next.next;
            temp1.next = temp1.next.next;
            curr.next.next = temp1;
            dummy = dummy.next.next;    
        }
        return head;

    }
}

/**19. Remove Nth Node From End of List (Medium)
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null)return null;
        int count = 1;
        ListNode curr = head;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }
        int m = count - n;
        if(m == 0 && head.next != null){
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        curr = head;
        count = 0;
        while(count < m){
            dummy = dummy.next;
            curr = curr.next;
            count++;
        }
        dummy.next = curr.next;
        return head;

    }
}