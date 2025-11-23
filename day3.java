/**leetcode 203 Remove Linked List Elements
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * https://leetcode.com/problems/remove-linked-list-elements/
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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return head;
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }else{
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;//think about if head.val == val, so curr should point to dummy
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;//because head might be remove already
    }
}

/**Leetcode 207 Design Linked List
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
https://leetcode.com/problems/design-linked-list/description/
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        ListNode curr = head.next;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        size++;
        ListNode node = new ListNode(val);
        ListNode curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)return;
        size--;
        ListNode curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }
}

/**206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    public ListNode reverse(ListNode curr, ListNode prev){
        if(curr == null)return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(temp, curr);
    }
}