package Linkedlist;

public class T3_isPalindrome {
    /*
    先利用快慢指针找到链表中点
    然后两个指针一起遍历，如果不相等，直接输出false
     */
    public static boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next!= null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //反转前半链表
            ListNode halfHead = reverseList(slow.next);
            ListNode p1 = head;
            ListNode p2 = halfHead;
            boolean result = true;
            while (result&&p2!=null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return result;
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

    public static void main(String[] args) {
        int[] num = {1, 2, 2, 1};
        System.out.println(isPalindrome(ListNodeHelper.buildList(num))); // 输出 true

        int[] num2 = {1, 2, 3, 2, 1};
        System.out.println(isPalindrome(ListNodeHelper.buildList(num2))); // 奇数长度，输出 true

        int[] num3 = {1, 2, 3, 4};
        System.out.println(isPalindrome(ListNodeHelper.buildList(num3))); // 输出 false
    }

}
