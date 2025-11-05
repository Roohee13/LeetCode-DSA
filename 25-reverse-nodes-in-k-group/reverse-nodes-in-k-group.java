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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy =new ListNode(0);
        dummy.next= head;

        int count=0;
        ListNode temp = head;
        while(temp!=null){
            temp= temp.next;
            count++;
        } 

        temp=dummy;
        while(temp.next!=null){
            if(count<k) break;
            int nodes= k-1;
            ListNode tempnext= temp.next;
            ListNode first= temp.next;
            ListNode  second = first.next;
            while(nodes-- >0){
                ListNode next= second.next;
                second.next= first;
                first= second;
                second= next;
            }

            count = count-k;
            temp.next= first;
            tempnext.next= second;
            temp= tempnext;
        }
        return dummy.next;
    }
}