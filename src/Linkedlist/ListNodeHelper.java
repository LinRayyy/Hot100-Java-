package Linkedlist;

import java.util.Collection;

public class ListNodeHelper {

    // 加上这个重载方法：专门接收 int[] 数组
    public static ListNode buildList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int x : nums) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 将 Integer 集合转换为链表，返回头节点
    public static ListNode buildList(Collection<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int x : list) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }

        return dummy.next;
    }
    // 打印链表，输出格式如：1 -> 2 -> 3 -> null
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}