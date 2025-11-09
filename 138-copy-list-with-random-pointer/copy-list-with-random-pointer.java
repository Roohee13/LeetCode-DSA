/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        //step 1 : make copy of each node
        Node temp = head;
        while(temp!=null){
            Node next= temp.next;
            Node random= temp.random;
            temp.next=new Node(temp.val,next,random);
            temp=temp.next.next;
        }

        //step 2: shift the values of the random
        Node newHead= head.next;
        temp=head;
        while(temp!= null){
            Node next= temp.next;
            if(next.random!=null){
                next.random=next.random.next;

            }
            temp=temp.next.next;
        }


        //unwind the list : seperate the copy and list
        temp=head;
        while(temp!=null){
            Node copy = temp.next;
            temp.next= copy.next;
            if(copy.next!=null){
                copy.next=copy.next.next;
            }
            temp=temp.next;
        }

        return newHead;
    }
}