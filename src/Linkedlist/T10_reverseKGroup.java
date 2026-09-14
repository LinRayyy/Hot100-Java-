package Linkedlist;

public class T10_reverseKGroup {

    /*
    设置两个指针start end,让end移动k步，如果是null,结束。如果非空，把以start开头，end结尾的链表分离出来
    反接在原链表中
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy.next;
        ListNode end = dummy.next;
        ListNode prevStart = dummy;
        ListNode afterEnd = dummy;
        int count=0;
        while(end!=null){
            count++;
            if(count==k){
                //获取afterEnd
                afterEnd=end.next;
                end.next=null;
                //获取单独链表
                reverseList(start);
                //通过prevStart和afterEnd反接
                prevStart.next=end;
                start.next=afterEnd;
                //更新start end prevStart
                prevStart=start;
                start = afterEnd;
                end=afterEnd;
                count=0;
            }
            else end=end.next;
        }
        return dummy.next;

    }

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
}
