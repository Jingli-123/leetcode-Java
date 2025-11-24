/**24. Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/description/
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