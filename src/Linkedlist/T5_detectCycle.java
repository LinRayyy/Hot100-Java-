package Linkedlist;

public class T5_detectCycle {
    /*
        寻找环形链表环入口
        1。开始依旧快慢指针（快指针的速度是慢指针的两倍），在有环的情况下，快慢指针相遇时候，路程差为n倍的圈路程
        2。也就是说从起点到相遇点的距离（S1）等于n倍的圈路程(S2)，设环入口到相遇点的距离为S
        3.等式变换，即S1-S=S2-S
        4.令p为头指针，以和slow相同的速度从起点出发，两个指针最后会在环入口相遇
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){

                ListNode p1 = head;
                while(p1!=slow){
                    p1 = p1.next;
                    slow = slow.next;
                }
                return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 构造节点
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3); // 环入口
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3; // 制造环！5指向3

        ListNode ans = detectCycle(n1);
        System.out.println(ans == null ? "null" : ans.val); //预期输出3
    }
}
