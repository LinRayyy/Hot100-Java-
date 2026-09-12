package Linkedlist;

public class T1_getIntersectionNode {



    /*
    假设链表A的独有长度为a,公共长度为c.链表B独有长度为b,公共长度为c
    让A B头指针同时走
    当链表A头指针先走A长度（a+c），再走完B的独有长度（b）,与刚走完链表B（b+c）和链表A的独有长度(a)的头指针将会在公共起始点回合
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
