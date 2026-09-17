package Linkedlist;

import java.util.PriorityQueue;

public class T13_mergeKLists {


    /*
    归并算法
     */
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideListNode(lists,0,lists.length-1);
    }

    public static ListNode divideListNode(ListNode[] lists, int l, int r) {
        if(l>r)return null;
        if(l==r)return lists[l];
        //先找到中点mid
        int mid = (l+r)/2;
        //获取左数组和右数组
        //放入divideListNode进行递归
        ListNode l1 = divideListNode(lists,l,mid);
        ListNode l2 = divideListNode(lists,mid+1,r);
        //合并并返回
        return merge(l1,l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            int v1=l1.val;
            int v2=l2.val;
            if(v1>v2){
                curr.next = l2;
                l2 = l2.next;
            }
            else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        //接上剩下的部分
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        return dummy.next;
    }


    /*
    优先队列解决
     */
    public ListNode mergeKLists_pq(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //创建一个存储ListNode的优先队列，按照val值从小到大排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b)->Integer.compare(a.val,b.val)
        );
        //把所有的头指针放进去排序
        for (ListNode l : lists) {
            if (l != null) pq.add(l);
        }
        //开始循环，如果弹出来的指针.next不为null,则把它放入优先队列中
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            if(nextNode.next != null) {
                pq.add(nextNode.next);
            }
            curr = curr.next;//易错点curr没有后移
        }
        //返回
        return dummy.next;
    }
}
