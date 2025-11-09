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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length= 1;
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }

        temp.next=head;

        k=k%length;
        int stepsToMove= length-k;
        ListNode newTail= temp;
        while(stepsToMove >0){
            newTail=newTail.next;
            stepsToMove--;
        }

        ListNode newhead=newTail.next;
        newTail.next=null;

        return newhead;
    } 
}