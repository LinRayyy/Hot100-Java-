package Linkedlist;

public class T9_swapPairs {
    /*
    链表相邻两两元素交换伪代码
    t=p.next
    p.next=p.next.next
    t.next=p.next.next
    p.next.next=t
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode t=p.next;
            p.next=p.next.next;
            t.next=p.next.next;
            p.next.next=t;

            p=p.next.next;
        }
        return dummy.next;
    }
}
