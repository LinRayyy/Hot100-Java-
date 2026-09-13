package Linkedlist;

public class T7_addTwoNumbers {
    /*
    carry存储进位
    循环条件while(p1!=null||p2!=null||carry!=0)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode p=dummy;
        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null||p2!=null||carry!=0){
            //判断两个链表的数字，如果是null,默认为0
            int d1=p1!=null?p1.val:0;
            int d2=p2!=null?p2.val:0;
            //计算总和
            int sum=d1+d2+carry;
            int digit=sum%10;//计算数位数字
            carry=sum/10;//计算进位
            p.next=new ListNode(digit);
            p=p.next;
            //更新p1 p2
            if(p1!=null)p1=p1.next;
            if(p2!=null)p2=p2.next;
        }
        return dummy.next;
    }
}
