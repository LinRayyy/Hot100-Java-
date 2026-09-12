package Linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T2_reverseList {

/*
双指针迭代
四步走：1.先存入下一个节点。2反转方向，改变next的指向。3，prev前面指针往前一步。4.curr现在指针往前一步
 */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode= curr.next;
            curr.next=prev;
            prev=curr;
            curr=tempNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] l = {1, 2, 3, 4, 5};
        ListNode head = ListNodeHelper.buildList(l);
        ListNodeHelper.printList(reverseList(head));
    }
}
