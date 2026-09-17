package Linkedlist;

import java.util.PriorityQueue;

public class T12_sortList {

    public ListNode sortList(ListNode head){
        //判断一个节点或者空节点
        if(head == null || head.next == null){
            return head;
        }
        //利用快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head.next;//易错点：fast要用head.next,不然会爆栈
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //获得左链表和右链表
        ListNode mid=slow.next;
        slow.next = null;
        //递归
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        //合并两个有序链表
        return mergeTwoLists(left,right);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建虚拟节点dummy,curr=dummy
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        //开始循环，循环条件是 l1!=null&&l2!=null
        while(l1 != null && l2 != null){
            int n1 = l1.val;
            int n2 = l2.val;
            if(n1>n2){
                //接l2
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        //找到没有遍历到头的链表，接上剩下的部分
        if(l1 != null)curr.next = l1;
        if(l2 != null)curr.next = l2;
        //返回
        return dummy.next;
    }


    /*
    使用优先队列存入所有数据，再倒序组成链表
     */
    public ListNode sortList_second(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //创建从小到大开始排序的优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //获取头指针，边遍历边存入数值
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        while(curr!= null) {
            int val = curr.val;
            pq.offer(val);
            curr = curr.next;
        }
        //修改val
        curr=head;
        while(!pq.isEmpty()) {
            int val = pq.poll();
            curr.val=val;
            curr=curr.next;
        }
        return head;
    }
}
