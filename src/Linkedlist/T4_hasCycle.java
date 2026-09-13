package Linkedlist;

import java.util.HashSet;

public class T4_hasCycle {
    /*
    方法一快慢指针
    1.slow每次走一格，fast每次走两个
    2.如果存在环，两个指针必然相遇，返回true;如果不存在环，fast先遇到空指针，结束循环返回false
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //易错点：如果判断条件写fast.next!=null&&fast.next.next!=null可能会导致循环直接结束，如果 1-》2-》null
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)return true;
        }
        return false;
    }

    /*
    方法二：哈希表，每次接收到一个节点，就把对应的值放到哈希表里。一旦重复，就返回true
     */
    public static boolean hasCycle_2(ListNode head){
        HashSet<Integer>hashSet = new HashSet<>();
        ListNode n = head;
        while(n!=null){
            if(hashSet.contains(n.val))return true;
            hashSet.add(n.val);
        }
        return false;
    }

    public static void main(String[] args) {
        // 手动创建节点
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        // 串起来
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n4; // 关键！尾节点指向n4，造出环

        System.out.println(hasCycle_2(n1)); // true
    }
}
